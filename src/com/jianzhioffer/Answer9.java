package com.jianzhioffer;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * */
public class Answer9 implements AnswerBase{
    /**
     * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
     * */
    public static void main(String [] args){
        Answer9 answer9 = new Answer9();
        answer9.printMain();

    }


    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        int n = 10;
        jumpFloor(n);
    }

    /**
    * ��ʵ������һ���������⣬������Ϊ0~(n-1)���������� = C(0,n-1) + C(1,n-1) + C(2,n-1) + ... + C(n-1,n-1) = 2^(n-1)���ù�ʽ��������ϵĶ���ʽ����ó�
    * */
    private int jumpFloor(int n){
        //n=1ʱ������1��
        //n=2ʱ������2 = 2 * number
        //n=3ʱ������  = 2 * 2 * number
        int number = 1;
        for(int i=1; i<n; i++){
            number = number * 2;
        }
        return number;
    }
}












