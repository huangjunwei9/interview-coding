package com.jianzhioffer;

public class Answer8 implements AnswerBase {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */

    public static void main(String [] args){
        Answer8 answer8 = new Answer8();
        answer8.printMain();
    }


    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        int n = 39;
        jumpFloor(n);
    }


    /** 思路，青蛙跳台阶实际上类似于 斐波那契数列 的算法。
    * 假设现在目标是第6个台阶，则可以是从第5跳一步到6，也可以是从第4跳两级到6，其他的不能从3跳到6，
    * 所以最后就是f(6) = f(5) + f(4)
    * */
    private int jumpFloor(int target) { //target为目标台阶
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
















