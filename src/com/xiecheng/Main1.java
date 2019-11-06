package com.xiecheng;

/**
 * @Author �ƾ���
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
    /*������������������ʵ����ĿҪ��Ĺ���
    ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
    ******************************��ʼд����******************************/
    //�൱����array.length �������У�����m-1�����壬�ж����ָ����ķ�����ÿ�ָ����ķ����е����ֵ�����˴��ַ��������ʱ��
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
    /******************************����д����******************************/


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
