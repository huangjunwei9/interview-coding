package com.jianzhioffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * */
public class Answer9 implements AnswerBase{
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * */
    public static void main(String [] args){
        Answer9 answer9 = new Answer9();
        answer9.printMain();

    }


    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        int n = 10;
        jumpFloor(n);
    }

    /**
    * 这实际上是一个隔板问题，隔板数为0~(n-1)，跳法种数 = C(0,n-1) + C(1,n-1) + C(2,n-1) + ... + C(n-1,n-1) = 2^(n-1)，该公式由排列组合的二项式定理得出
    * */
    private int jumpFloor(int n){
        //n=1时，返回1，
        //n=2时，返回2 = 2 * number
        //n=3时，返回  = 2 * 2 * number
        int number = 1;
        for(int i=1; i<n; i++){
            number = number * 2;
        }
        return number;
    }
}












