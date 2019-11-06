package com.jianzhioffer;

public class Answer8 implements AnswerBase {
    /**
     * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
     * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
     */

    public static void main(String [] args){
        Answer8 answer8 = new Answer8();
        answer8.printMain();
    }


    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        int n = 39;
        jumpFloor(n);
    }


    /** ˼·��������̨��ʵ���������� 쳲��������� ���㷨��
    * ��������Ŀ���ǵ�6��̨�ף�������Ǵӵ�5��һ����6��Ҳ�����Ǵӵ�4��������6�������Ĳ��ܴ�3����6��
    * ����������f(6) = f(5) + f(4)
    * */
    private int jumpFloor(int target) { //targetΪĿ��̨��
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = one+ two;
            one = two;
            two = result;
        }
        return result;
    }

}
















