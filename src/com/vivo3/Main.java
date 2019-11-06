package com.vivo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author »Æ¾üÍþ
 * @email hjunwei@foxmail.com
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
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

    private static int solution(int[] input) {

        // TODO Write your code here
        int sum = 0;
        for(int i=0; i<input.length; i++){
            sum = sum + input[i];
        }

        int sum1 = input[0];
        int sum2 = 0;
        for(int i=1; i<input.length; i++){
            if(sum1 > sum2+input[i] ){
                sum2 = sum2 + input[i];
            }else{
                sum1 = sum1 + input[i];
            }
        }
        int result = 0;
        if(sum1 >= sum2){
            result = sum1 - sum2;
        }else{
            result = sum2 - sum1;
        }


        return result;
    }
}
