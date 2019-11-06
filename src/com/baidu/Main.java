package com.baidu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author »Æ¾üÍþ
 * @create 2019/9/15 19:25
 * @email hjunwei@foxmail.com
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int a = 0;
        int b = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            if((n-a)*(m-b)>k){
                a--;
            }
            if((n-a)*(m-b)>k){
                b--;
            }
            if((n-a)*(m-b)<=k){
                arrayList.add(a+b);
                break;
            }
            arrayList.add(a+b);
        }

        int [] array = new int [arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            array[i] = arrayList.get(i);
        }
        Arrays.sort(array);

        System.out.println(array[array.length-1]);
    }
}
