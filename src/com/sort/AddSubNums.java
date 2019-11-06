package com.sort;

import java.util.Scanner;

public class AddSubNums {

    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

        /* 最大递增子序列 */
        AddSubNums addSubNums = new AddSubNums();
        addSubNums.AddSubNumsMain();
    }


    public void AddSubNumsMain(){
        /* 最大递增子序列 */
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        //记录每个位置最长递增子序列的长度
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;//无论从何处开始，长度都至少为1
            for (int j = 0; j < i; j++) {
                //如果是i位置大于j位置，并且j位置的最长递增子序列的长度+1 长于 目前i位置的最长递增子序列的长度，则更新i位置的最长递增子序列
                if (nums[j] <= nums[i] &&
                        result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i : result){ //i依次取result中的值，求result中的最大值
            if(i > max ){
                max = i;
            }

        }
        System.out.println(max);

    }

}
