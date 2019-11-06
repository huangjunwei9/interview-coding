package com.thread.threadpooleasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/** Ĭ���̳߳�
 * @Author �ƾ���
 * @create 2019/9/8 3:18
 * @email hjunwei@foxmail.com
 */
public class DefaultThreadPool<Task extends Runnable> implements ThreadPools<Task>{
    /**
     * �̳߳�ά���������̵߳��������
     */
    private static final int MAX_WORKER_NUMBERS=30;

    /**
     * �̳߳�ά���������̵߳�Ĭ�Ϲ�������
     */
    private static final int DEFAULT_WORKER_NUMBERS = 5;

    /**
     * �̳߳�ά���������̵߳���С����
     */
    private static final int MIN_WORKER_NUMBERS = 1;

    /**
     * �����б�ά��һ�������б�,�������ͻ��˷���Ĺ���
     */
    private final LinkedList<Task> taskLinkedList = new LinkedList<>();

    /**
     * ����ͬ�����ƵĹ����߳��б�
     */
    private final List<WorkerRunnable> workerRunnableList = Collections.synchronizedList(new ArrayList<WorkerRunnable>());

    /**
     * �����̵߳�����
     */
    private int workerNum;

    /**
     * ÿ�������̱߳�����ɣ�AtomicLong��CAS��֤ÿ�ζ����������ڴ��е�ֵ��
     */
    private AtomicLong workThreadIndexNum = new AtomicLong();

    /**
     * ���캯�������ڳ�ʼ���̳߳أ����ù����̵߳�����
     * ���ȣ��жϳ�ʼ���̳߳ص��̸߳����Ƿ��������߳���������������̳߳ص�Ĭ�ϳ�ʼ��ֵΪ DEFAULT_WORKER_NUMBERS
     * Ȼ�󣬳�ʼ��workerNum�������̣߳�����start()�������й����߳�
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
     * ��ʼ������start()����workerNum�������߳�
     */
    private void initializeWorkers(int workerNum) {
        for (int i = 0; i < workerNum; i++) {
            WorkerRunnable workerRunnable = new WorkerRunnable();
            //��ӵ��������̵߳��б�
            workerRunnableList.add(workerRunnable);
            //�����������߳�
            Thread thread = new Thread(workerRunnable);
            thread.start();
        }
    }

    /**
     * ִ��һ������(Task),���Job����ʵ��Runnable
     */
    @Override
    public void execute(Task task) {
        //���taskΪnull���׳���ָ��
        if (task ==null){
            throw new NullPointerException();
        }
        //���task�ǿ� TODO ˼��������������ʱ�򣬿��������ʱ����߳���
        if (task != null) {
            /** �����̵߳�"�ȴ�/֪ͨ����"��������jobs����
             * 1.��������ӵ������б��ĩβ
             * 2.֪ͨ�����̡߳����������б��������
             * */
            synchronized (taskLinkedList) {
                taskLinkedList.addLast(task);
                taskLinkedList.notify(); //ֻ�������һ�� wait �߳�
            }
        }

    }

    /**
     * �ر��̳߳�
     */
    @Override
    public void shutdown() {
        for (WorkerRunnable workerRunnable : workerRunnableList) {
            workerRunnable.shutdown();
        }
    }

    /**
     * ���ӹ������̣߳�������ִ��������߳�
     * @param num
     */
    @Override
    public void addWorkers(int num) {
        //��������ֹ���̻߳�û������ɶ��¸��̼߳������ӵ��¹������̳߳������ֵ
        synchronized (taskLinkedList) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    /**
     * ���ٹ����߳�
     * @param num
     */
    @Override
    public void removeWorker(int num) {
        synchronized (taskLinkedList) {
            if(num>=this.workerNum){
                throw new IllegalArgumentException("���������е��߳�����");
            }
            for (int i = 0; i < num; i++) {
                WorkerRunnable workerRunnable = workerRunnableList.get(i);
                if (workerRunnable != null) {
                    //�رո��̲߳����б����Ƴ�
                    workerRunnable.shutdown();
                    workerRunnableList.remove(i);
                }
            }
            this.workerNum -= num;
        }

    }

    /**
     * ��ȡ���ڵȴ�ִ�е���������
     */
    @Override
    public int getJobSize() {
        return workerRunnableList.size();
    }

    /**
     * �����ߣ������߳�
     */
    class WorkerRunnable implements Runnable {
        // ��ʾ�Ƿ����и�worker
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Task task = null;
                /** �̵߳ĵȴ�/֪ͨ���ƣ���ס�����б�
                 * 1.��������б�Ϊ�գ����ø��߳�wait()��ֱ������������ӵ������б�����notify()�ⲿ���Ѹ��߳�
                 * 2.��������б�Ϊ�գ���ȡ����һ�����񣬲��ø��߳�ִ�и��������run()
                 * */
                synchronized (taskLinkedList) {
                    if (taskLinkedList.isEmpty()) {
                        try {
                            taskLinkedList.wait();//�̵߳ȴ�����
                        } catch (InterruptedException e) {
                            //��֪���ⲿ�Ը��̵߳��жϲ���������
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // ȡ��һ��task
                    task = taskLinkedList.removeFirst();
                }
                //ִ��task��������task��public void run()����
                if (task != null) {
                    task.run();
                }
            }
        }

        /**
         * ��ֹ���߳�
         */
        public void shutdown() {
            running = false;
        }
    }

}
