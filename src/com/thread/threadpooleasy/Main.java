package com.thread.threadpooleasy;

/**
 * @Author �ƾ���
 * @create 2019/9/8 3:19
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        //�����̳߳أ����ÿ�ͬʱ�������̵߳�����=10
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool(10);

        //���̳߳��ж�numOfTask������
        int numOfTask = 32;
        for (int i=1; i<=numOfTask; i++){
            //�����񳬹�30��ʱ�����ӹ������̣߳�������ִ��������߳�
            if (i==31){
                defaultThreadPool.addWorkers(10);
            }
            Job job = new Job();
            defaultThreadPool.execute(job);
        }
    }
}
