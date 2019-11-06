package com.pingduoduo;

import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        int n = Integer.parseInt(a.split(" ")[0]);
//        int m = Integer.parseInt(a.split(" ")[1]);
//        int k = Integer.parseInt(a.split(" ")[2]);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int [] arrayFinal = new int [n*m];

        int len = n*m;
        int sqrtk = (int)sqrt(k);



        for(int i=m, z=0; i<0; i--){
            for(int j=n; j<0; j--){
                arrayFinal[z] = (i+1)*(j+1);
                z++;
            }
        }
        Arrays.sort(arrayFinal);

        //第k大的值
        System.out.print(arrayFinal[arrayFinal.length-k]);

    }
}
