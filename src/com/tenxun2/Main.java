package com.tenxun2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 黄军威
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int [] a = new int [n];
        for(int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        //计算 值与值之间的差
        int [] b = new int [a.length];
        b[0] = a[0];
        for(int i=1; i<a.length; i++){
            b[i] = a[i] - a[i-1];
        }

        int index = 0;

        //第k轮
        int i=0;
        while( i<k && index<b.length ){   //如果i >= k，说明输出完毕；否则没有输出完毕，再判断如果，需要再输出 k-i 个0
            while( index < b.length ){
                if(b[index] != 0 ){
                    System.out.println(b[index]);
                    index++;
                    i++;
                    break;
                }else{
                    index++;
                }
            }
        }

        for(int cha = k-i; cha > 0; cha--){
            System.out.println("0");
        }

//        if(k-i > 0){
//            System.out.println("0");
//        }

    }
}
