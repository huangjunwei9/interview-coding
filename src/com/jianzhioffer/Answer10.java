package com.jianzhioffer;

import java.util.Scanner;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */
public class Answer10 implements  AnswerBase {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * */
    public static void main(String [] args){
        Answer10 answer10 = new Answer10();
        answer10.printMain();
    }


    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 4;
        System.out.println(RectCover(n));
    }

    /*
    * 思路，还是类似斐波那契数列
    *
    * */
    private int RectCover(int n){
        if(n < 0){
            System.out.println("输入的数据不在范围内");
            return -1;
        }
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int result = 0;
        if(n>=3){
            int s1 = 1;
            int s2 = 2;
            for(int i=3; i<=n; i++){
                result = s1 + s2;
                s1 = s2;
                s2 = result;
            }
        }
        return result;
    }
}












