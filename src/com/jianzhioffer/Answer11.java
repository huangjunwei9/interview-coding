package com.jianzhioffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class Answer11 implements AnswerBase{
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * */
    public static void main(String [] args){
        Answer11 answer11 = new Answer11();
        answer11.printMain();
    }


    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        int n = -128;
        System.out.println(numberOf1(n));
    }

    /**
     * 方法1 利用系统自带的Integer.toBinaryString(target).toCharArray();函数
     * 缺点：不如位运算快
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
     * 方法2 利用位运算的方法
     * 一个整数减去1，再与原整数做与运算，会将最右边的一个1变成0，
     * */
    private int numberOf1Solution2(int target){
        int result =0;
        while(target != 0){
            result++;
            target = target & (target -1); //1的数量一个一个地减少
        }
        return result;
    }


}
