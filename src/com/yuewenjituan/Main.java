package com.yuewenjituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author �ƾ���
 * @create 2019/9/16 18:53
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  //��������
        while(t != 0){
            t--;

            int n = scanner.nextInt();  //n����
            int m = scanner.nextInt();  //m����

            //����m����
            Integer [] array1 = new Integer[m];
            Integer [] array2 = new Integer[m];
            for(int i=0; i<m; i++){
                array1[i] = scanner.nextInt();
                array2[i] = scanner.nextInt();
            }

            //�ҳ�������1�����ĵ㣬�ҳ�������n�����ĵ�
            HashSet<Integer> hashSet1 = new HashSet<>();
            HashSet<Integer> hashSetn = new HashSet<>();
            for(int i=0; i<m; i++){
                //�������1�����ĵ㣬��洢��hashSet1��
                if(array1[i] == 1){
                    hashSet1.add(array2[i]);
                }
                if(array2[i] == 1){
                    hashSet1.add(array1[i]);
                }

                //�������n�����ĵ㣬��洢��hashSetn��
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
                //�����ֱ�ӵ���ģ���ֱ��
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
