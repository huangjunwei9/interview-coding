package com.jianzhioffer;

import java.util.Scanner;

/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * */
public class Answer10 implements  AnswerBase {
    /**
     * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
     * */
    public static void main(String [] args){
        Answer10 answer10 = new Answer10();
        answer10.printMain();
    }


    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 4;
        System.out.println(RectCover(n));
    }

    /*
    * ˼·����������쳲���������
    *
    * */
    private int RectCover(int n){
        if(n < 0){
            System.out.println("��������ݲ��ڷ�Χ��");
            return -1;
        }
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int result = 0;
        if(n>=3){
            int s1 = 1;
            int s2 = 2;
            for(int i=3; i<=n; i++){
                result = s1 + s2;
                s1 = s2;
                s2 = result;
            }
        }
        return result;
    }
}












