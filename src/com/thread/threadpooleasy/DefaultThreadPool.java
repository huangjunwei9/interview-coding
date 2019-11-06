package com.thread.threadpooleasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/** 默认线程池
 * @Author 黄军威
 * @create 2019/9/8 3:18
 * @email hjunwei@foxmail.com
 */
public class DefaultThreadPool<Task extends Runnable> implements ThreadPools<Task>{
    /**
     * 线程池维护工作者线程的最大数量
     */
    private static final int MAX_WORKER_NUMBERS=30;

    /**
     * 线程池维护工作者线程的默认工作数量
     */
    private static final int DEFAULT_WORKER_NUMBERS = 5;

    /**
     * 线程池维护工作者线程的最小数量
     */
    private static final int MIN_WORKER_NUMBERS = 1;

    /**
     * 任务列表：维护一个工作列表,里面加入客户端发起的工作
     */
    private final LinkedList<Task> taskLinkedList = new LinkedList<>();

    /**
     * 具有同步机制的工作线程列表
     */
    private final List<WorkerRunnable> workerRunnableList = Collections.synchronizedList(new ArrayList<WorkerRunnable>());

    /**
     * 工作线程的数量
     */
    private int workerNum;

    /**
     * 每个工作线程编号生成（AtomicLong用CAS保证每次都是最新主内存中的值）
     */
    private AtomicLong workThreadIndexNum = new AtomicLong();

    /**
     * 构造函数：用于初始化线程池，设置工作线程的数量
     * 首先，判断初始化线程池的线程个数是否大于最大线程数，如果大于则线程池的默认初始化值为 DEFAULT_WORKER_NUMBERS
     * 然后，初始化workerNum个工作线程，并用start()启动所有工作线程
     */
    public DefaultThreadPool(int num){
        if (num > MAX_WORKER_NUMBERS) {
            this.workerNum =DEFAULT_WORKER_NUMBERS;
        } else {
            this.workerNum = num;
        }
        initializeWorkers(workerNum);
    }

    /**
     * 初始化并用start()启动workerNum个工作线程
     */
    private void initializeWorkers(int workerNum) {
        for (int i = 0; i < workerNum; i++) {
            WorkerRunnable workerRunnable = new WorkerRunnable();
            //添加到工作者线程的列表
            workerRunnableList.add(workerRunnable);
            //启动工作者线程
            Thread thread = new Thread(workerRunnable);
            thread.start();
        }
    }

    /**
     * 执行一个任务(Task),这个Job必须实现Runnable
     */
    @Override
    public void execute(Task task) {
        //如果task为null，抛出空指针
        if (task ==null){
            throw new NullPointerException();
        }
        //如果task非空 TODO 思考：当供大于求时候，考虑如何临时添加线程数
        if (task != null) {
            /** 根据线程的"等待/通知机制"这里必须对jobs加锁
             * 1.把任务添加到任务列表的末尾
             * 2.通知所有线程——“任务列表解锁”了
             * */
            synchronized (taskLinkedList) {
                taskLinkedList.addLast(task);
                taskLinkedList.notify(); //只随机唤醒一个 wait 线程
            }
        }

    }

    /**
     * 关闭线程池
     */
    @Override
    public void shutdown() {
        for (WorkerRunnable workerRunnable : workerRunnableList) {
            workerRunnable.shutdown();
        }
    }

    /**
     * 增加工作者线程，即用来执行任务的线程
     * @param num
     */
    @Override
    public void addWorkers(int num) {
        //加锁，防止该线程还没增加完成而下个线程继续增加导致工作者线程超过最大值
        synchronized (taskLinkedList) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    /**
     * 减少工作线程
     * @param num
     */
    @Override
    public void removeWorker(int num) {
        synchronized (taskLinkedList) {
            if(num>=this.workerNum){
                throw new IllegalArgumentException("超过了已有的线程数量");
            }
            for (int i = 0; i < num; i++) {
                WorkerRunnable workerRunnable = workerRunnableList.get(i);
                if (workerRunnable != null) {
                    //关闭该线程并从列表中移除
                    workerRunnable.shutdown();
                    workerRunnableList.remove(i);
                }
            }
            this.workerNum -= num;
        }

    }

    /**
     * 获取正在等待执行的任务数量
     */
    @Override
    public int getJobSize() {
        return workerRunnableList.size();
    }

    /**
     * 消费者：工作线程
     */
    class WorkerRunnable implements Runnable {
        // 表示是否运行该worker
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Task task = null;
                /** 线程的等待/通知机制，锁住任务列表
                 * 1.如果任务列表为空，则让该线程wait()，直到：有任务添加到任务列表，并用notify()外部唤醒该线程
                 * 2.如果任务列表不为空，则取出第一个任务，并让该线程执行该任务里的run()
                 * */
                synchronized (taskLinkedList) {
                    if (taskLinkedList.isEmpty()) {
                        try {
                            taskLinkedList.wait();//线程等待唤醒
                        } catch (InterruptedException e) {
                            //感知到外部对该线程的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 取出一个task
                    task = taskLinkedList.removeFirst();
                }
                //执行task，即调用task的public void run()方法
                if (task != null) {
                    task.run();
                }
            }
        }

        /**
         * 终止该线程
         */
        public void shutdown() {
            running = false;
        }
    }

}
