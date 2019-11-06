package com.xiecheng;

/**
 * @Author 黄军威
 * @create 2019/9/4 20:32
 * @email hjunwei@foxmail.com
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import static java.lang.Math.max;

public class Main1 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    //相当于在array.length 个数据中，插入m-1个隔板，有多少种隔开的方法，每种隔开的方法中的最大值决定了此种方法的最短时间
    static int schedule(int m,int[] array) {
        List<Integer> list = new ArrayList<>();
        int a=0;
        int b=0;
        int c=0;
        int result = 0;

        int i=0,j=0,k=0,temp=0;
        for(i=0; i<array.length-1; i++){
            a = a + array[i];
            for(j=i+1; j<array.length; j++){
                b = b + array[j];
                for(k=j+1; k<array.length; k++){
                    c = c + array[k];
                    temp = max(max(a,b),c);
                    list.add(temp);
                }

            }
        }
        int [] n = new int[list.size()];
        for(int z=0; m<list.size(); m++){
            n[m] = list.get(m);
        }
        Arrays.sort(n);



        return n[n.length-1];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
