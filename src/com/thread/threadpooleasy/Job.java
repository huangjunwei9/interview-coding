package com.thread.threadpooleasy;

/** ����
 * @Author �ƾ���
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
            System.out.println("��ǰ�߳�����:"+Thread.currentThread().getName()+";"+"job��ִָ����" + JOB_TIME + "��");
            JOB_TIME++;
        }

    }
}
