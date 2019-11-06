package com.xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author »Æ¾üÍþ
 * @create 2019/8/18 15:11
 * @email hjunwei@foxmail.com
 */
public class SecondQuestion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(sc.hasNext()){
            arrayList.add(sc.nextInt());
        }

        int [] dataInt = new int [arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            dataInt[i] = arrayList.get(i);
        }

    }
}
