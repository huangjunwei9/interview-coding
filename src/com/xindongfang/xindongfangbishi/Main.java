package com.xindongfang.xindongfangbishi;
import java.util.Scanner;

/**
 * @Author �ƾ���
 * @create 2019/8/24 1:34
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = numberWay(n);

        //���
        System.out.println(result);

    }

    //���ص�n���ķ�����
    public static int numberWay(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 2; i < n; i++){
            result = first+ second;
            first = second;
            second = result;
        }
        return result;
    }

}
