package com.thread.threadpooleasy;

/** 任务，
 * @Author 黄军威
 * @create 2019/9/8 3:19
 * @email hjunwei@foxmail.com
 */
public class Job implements Runnable{
    private static Integer JOB_TIME = 1;
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (JOB_TIME){
            System.out.println("当前线程名称:"+Thread.currentThread().getName()+";"+"job被指执行了" + JOB_TIME + "次");
            JOB_TIME++;
        }

    }
}
