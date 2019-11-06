package com.thread.threadpooleasy;

/**
 * @Author 黄军威
 * @create 2019/9/8 3:19
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        //创建线程池，设置可同时工作的线程的数量=10
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool(10);

        //往线程池中丢numOfTask个任务
        int numOfTask = 32;
        for (int i=1; i<=numOfTask; i++){
            //当任务超过30个时，增加工作者线程，即用来执行任务的线程
            if (i==31){
                defaultThreadPool.addWorkers(10);
            }
            Job job = new Job();
            defaultThreadPool.execute(job);
        }
    }
}
