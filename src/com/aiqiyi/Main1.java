package com.aiqiyi;

import java.util.Scanner;


public class Main1 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int [] a = new int[4];

        for(int i=0; i<4; i++){
            a[i] = scanner.nextInt();
        }


        int k = a[3];
        int num = 1;
        for(int i=0,j=0; i<k; ){
            if(a[0] > 1){
                num = num * 2;
                i++;
                a[j]--;//成功切割一次

                switch (j){
                    case 0:  j++; break;
                    case 1:  j++; break;
                    case 2:  j=0; break;
                }
            }
        }
        System.out.println(num);

    }
}
