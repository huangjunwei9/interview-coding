package com.thread.threadpooleasy;

/** �̳߳ط�������
 * @Author �ƾ���
 * @create 2019/9/8 3:17
 * @email hjunwei@foxmail.com
 */
public interface ThreadPools<Task extends Runnable>{

    /**
     * ִ��һ������(Task),����������ʵ��Runnable
     * @param task
     */
    public void execute(Task task);

    /**
     * �ر��̳߳�
     */
    public void shutdown();

    /**
     * ���ӹ������̣߳�������ִ��������߳�
     * @param num
     */
    public void addWorkers(int num);

    /**
     * ���ٹ������߳�
     * @param num
     */
    public void removeWorker(int num);

    /**
     * ��ȡ���ڵȴ�ִ�е���������
     */
    public int getJobSize();
}
