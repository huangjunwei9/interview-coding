package com.xindongfang.xindongfangbishi;

import java.util.Scanner;

/**
 * @Author �ƾ���
 * @create 2019/8/29 19:52
 * @email hjunwei@foxmail.com
 */
public class Main2 {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        String allString = in.nextLine();
        String [] stringArray = allString.split("/r");
        String [] stringArray0 = stringArray[0].split(",");
        String [] stringArray1 = stringArray[1].split(",");

        int [] arrayInt0 = new int[stringArray0.length];//��1������
        int [] arrayInt1 = new int[stringArray1.length];//��2������
        int [] arrayInt2 = new int[stringArray1.length];//��2������

        for(int i=0; i<arrayInt0.length; i++){
            arrayInt0[i] = Integer.parseInt(stringArray0[i]);
        }

        for(int i=0; i<arrayInt1.length; i++){
            arrayInt1[i] = Integer.parseInt(stringArray1[i]);
        }

        for(int i=0; i<arrayInt2.length; i++){
            if(i==0){
                System.out.println("[");
            }
            System.out.println(arrayInt2[i]);
            if( i<(arrayInt2.length-1) ){
                System.out.println(",");
            }
            if(i==(arrayInt2.length-1)){
                System.out.println("]");
            }


        }


        //���

    }
}
