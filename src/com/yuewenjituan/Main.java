package com.yuewenjituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author 黄军威
 * @create 2019/9/16 18:53
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  //数据组数
        while(t != 0){
            t--;

            int n = scanner.nextInt();  //n个点
            int m = scanner.nextInt();  //m条边

            //输入m条边
            Integer [] array1 = new Integer[m];
            Integer [] array2 = new Integer[m];
            for(int i=0; i<m; i++){
                array1[i] = scanner.nextInt();
                array2[i] = scanner.nextInt();
            }

            //找出所有与1相连的点，找出所有与n相连的点
            HashSet<Integer> hashSet1 = new HashSet<>();
            HashSet<Integer> hashSetn = new HashSet<>();
            for(int i=0; i<m; i++){
                //如果有与1相连的点，则存储到hashSet1中
                if(array1[i] == 1){
                    hashSet1.add(array2[i]);
                }
                if(array2[i] == 1){
                    hashSet1.add(array1[i]);
                }

                //如果有与n相连的点，则存储到hashSetn中
                if(array1[i] == n){
                    hashSetn.add(array2[i]);
                }
                if(array2[i] == n){
                    hashSetn.add(array1[i]);
                }
            }

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int index = 0;

            Iterator iterator = hashSet1.iterator();
            while(iterator.hasNext()){
                if(hashSetn.contains(iterator.next())){
                    index = 1;
                    break;
                }
            }

            for(int i=0; i<m; i++){
                //如果有直接到达的，则直接
                if( (array1[i] == 1 && array2[i] == n) || (array1[i] == n && array2[i] == 1) ){
                    index = 1;
                    break;
                }
            }

            if(index == 1){
                System.out.println("POSSIBLE");
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }

    }
}
