package com.tenxun1;

import java.util.Scanner;

/**
 * @Author 黄军威
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        //第i组
        for(int i=0; i<t; i++){
            int len = scanner.nextInt();
            scanner.nextLine();
            String string = scanner.nextLine();
            char [] array = string.toCharArray();

            if(len != array.length){
                System.out.println("NO");
                continue;
            }

            if(len < 11){
                System.out.println("NO");
                continue;
            }

            //找到第一个8的位置k，用len-k，如果len-k < 11，则NO，否则YES。
            //如果没有8，则输出NO
            int index = -1;
            for(int k=0; k<len; k++){
                if(array[k] == '8'){
                    index = k;
                    break;
                }
            }

            if(index == -1){
                System.out.println("NO");
                continue;
            }
            if( (len - index) < 11 ){
                System.out.println("NO");
                continue;
            }else{
                System.out.println("YES");
                continue;
            }

        }

    }
}











