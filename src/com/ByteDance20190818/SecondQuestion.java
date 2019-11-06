package com.ByteDance20190818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author »Æ¾üÍþ
 * @create 2019/8/18 15:11
 * @email hjunwei@foxmail.com
 */
public class SecondQuestion {

    public static void main(String[] args) {
//        Integer
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(sc.hasNext()){
            arrayList.add(sc.nextInt());
        }
        int total = sc.nextInt();
        int [] dataInt = new int [arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            dataInt[i] = arrayList.get(i);
        }


        int [] jian = new int [dataInt.length];
        for(int i=0; i<dataInt.length; i++){
            jian[i] = total - dataInt[i];
        }

        int first=0;
        int second=0;
        int index=0;
        for(int i=0; i<dataInt.length; i++){
            for(int j=i; j<dataInt.length; j++){
                if(jian[i] == dataInt[j]){
                    index=1;
                    first = dataInt[i];
                    second = jian[i];
                    break;
                }
            }
        }
        if(index == 1){
            System.out.println("" + first + " "+ second);
        }
    }
}
