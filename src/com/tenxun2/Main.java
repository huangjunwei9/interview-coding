package com.tenxun2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author �ƾ���
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

        //���� ֵ��ֵ֮��Ĳ�
        int [] b = new int [a.length];
        b[0] = a[0];
        for(int i=1; i<a.length; i++){
            b[i] = a[i] - a[i-1];
        }

        int index = 0;

        //��k��
        int i=0;
        while( i<k && index<b.length ){   //���i >= k��˵�������ϣ�����û�������ϣ����ж��������Ҫ����� k-i ��0
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
