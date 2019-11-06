package com.jianzhioffer;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * */
public class Answer11 implements AnswerBase{
    /**
     * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
     * */
    public static void main(String [] args){
        Answer11 answer11 = new Answer11();
        answer11.printMain();
    }


    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        int n = -128;
        System.out.println(numberOf1(n));
    }

    /**
     * ����1 ����ϵͳ�Դ���Integer.toBinaryString(target).toCharArray();����
     * ȱ�㣺����λ�����
     * */
    private int numberOf1(int target){
        int result = 0;
        char [] array = Integer.toBinaryString(target).toCharArray();
        for(int i=0; i <= array.length-1; i++){
            if(array[i] == '1'){
                result++;
            }
        }
        return result;
    }

    /**
     * ����2 ����λ����ķ���
     * һ��������ȥ1������ԭ�����������㣬�Ὣ���ұߵ�һ��1���0��
     * */
    private int numberOf1Solution2(int target){
        int result =0;
        while(target != 0){
            result++;
            target = target & (target -1); //1������һ��һ���ؼ���
        }
        return result;
    }


}
