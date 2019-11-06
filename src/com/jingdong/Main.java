package com.jingdong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author 黄军威
 * @create 2019/8/24 1:34
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] array = new int [N];
        int group = 0;
        for(int i=0; i<N; i++){
            array[i] = scanner.nextInt();
        }

        //2 1 3 2       2 1、3 2
        //2 1 1、3 2 、5 4 7 8
        //如果后面有数字比当前数字小，则则两个数字必须在一个组
        int index = 0;
        int sum = 1;
        int pre = 0;
        for(int i=0; i<N; ){

            for(int j=i+1; j<N; j++){
                if(array[i] > array[j] && (array[j] != array[pre])  ){
                    index = j;
                    group = 1;
                }
            }
            pre = i;

            if(group == 1){//必须分组了
                i = index + 1;
                sum++;
                group = 0;
            }else{//没分组
                i++;
            }


        }

        System.out.println(sum);

    }

}
