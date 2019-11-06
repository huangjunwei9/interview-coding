package com.thread.threadpooleasy;

/** 线程池方法定义
 * @Author 黄军威
 * @create 2019/9/8 3:17
 * @email hjunwei@foxmail.com
 */
public interface ThreadPools<Task extends Runnable>{

    /**
     * 执行一个任务(Task),这个任务必须实现Runnable
     * @param task
     */
    public void execute(Task task);

    /**
     * 关闭线程池
     */
    public void shutdown();

    /**
     * 增加工作者线程，即用来执行任务的线程
     * @param num
     */
    public void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num
     */
    public void removeWorker(int num);

    /**
     * 获取正在等待执行的任务数量
     */
    public int getJobSize();
}
