package com.jianzhioffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 * */
public class Answer7 implements AnswerBase{
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
     * */
    public static void main(String [] args){
        Answer7 answer7 = new Answer7();
        answer7.printMain();
    }

    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        int n = 39;

        long timeUse = System.currentTimeMillis();
        System.out.print("递归法：" + Fibonacci1(n) + ", ");
        System.out.println("\n递归法花费时间：" + (System.currentTimeMillis() - timeUse));

        timeUse = System.currentTimeMillis();
        System.out.print("循环法：" + Fibonacci2(n) + ", ");
        System.out.println("\n循环法花费时间：" + (System.currentTimeMillis() - timeUse));
    }

    /** 方法1：递归方法。缺点：时间和空间复杂度非常高，不建议采用
    * f(n) = f(n-2) + f(n-1),   n>=2
    * f(n) = 1,  n=1
    * f(n) = 0,  n=0
    * */
    private int Fibonacci1(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int fn = Fibonacci1(n-1) + Fibonacci1(n-2);
        return fn;
    }

    /** 方法2：循环法，优点：减低复杂度
     *
     * */
    private int Fibonacci2(int n) {
        int n0 = 0;
        int n1 = 1;

        if(n == 0){
            return n0;
        }
        if(n == 1){
            return n1;
        }

        int fn = 0;//用于返回的Fibonacci中的第n个数
        for(int i = 2;i<=n; i++){
            //先计算出前两个数的和，再使n0和n1一起右移
            fn = n0 + n1;
            n0 = n1;
            n1 = fn;
        }
        return fn;
    }

}











