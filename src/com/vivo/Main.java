package com.vivo;

import java.io.*;

/**
 * Welcome to vivo !
 */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        // TODO Write your code here
        int n = input[0];   //人数
        int m = input[1];   //除数
        int [] originArray = new int [n];
        int [] outputArray = new int [n]; //出来的人

        //初始化人的号码
        for(int i=0; i<n; i++){
            originArray[i] = i + 1;
        }

        int incData = 1;    //数数123456...
        int len = n;        //当前人数
        int numOutput = 0;   //当前出队人在outputArray[]中的下标
        while(len > 0){

            //在一个循环里把数组遍历一遍
            for(int i=0; i<n ; i++){
                if(originArray[i] != -1){
                    //如果当前计数值能整出M，则把该学生出队，当前人数-1
                    if( (incData % m == 0)  ){
                        //把该学生出队
                        outputArray[numOutput] = originArray[i];
                        numOutput++;
                        //当前人数-1
                        originArray[i] = -1;
                        len--;
                    }
                    //只要originArray[i] != -1，就让计数值自增1
                    incData++;
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer("" + outputArray[0]);

        for(int i=1; i<n; i++){
            stringBuffer.append( " " + outputArray[i]);
        }
        String result = stringBuffer.toString();

        return result;
    }

}
