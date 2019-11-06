package com.pingan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author »Æ¾üÍþ
 * @create 2019/9/26 9:05
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array = scanner.nextLine().split(",");
        int [] arrayData = new int[array.length];
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i=0; i<array.length; i++){
            arrayData[i] = Integer.parseInt(array[i]);
            if(map.containsKey(arrayData[i]) == true){
                map.put(arrayData[i], map.get(arrayData[i]) + 1);
            }else{
                map.put(arrayData[i], 1);
            }
        }
        Iterator iterator = map.keySet().iterator();
        int a = Integer.MIN_VALUE;
        while(iterator.hasNext()){
            a = ((Integer)iterator.next());
            if(  a > array.length/2);{
                System.out.println(a);
                break;
            }
        }


    }
}










