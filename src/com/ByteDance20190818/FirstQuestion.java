package com.ByteDance20190818;

import java.util.Scanner;

/**
 * @Author »Æ¾üÍþ
 * @create 2019/8/18 15:11
 * @email hjunwei@foxmail.com
 */
public class FirstQuestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String all = sc.nextLine();
        int total = sc.nextInt();
        String dataAll = all.substring(1,all.length()-1);
        String [] dataString = dataAll.split(", ");
        int [] dataInt = new int [dataString.length];
        for (int i=0; i<dataString.length; i++){
            dataInt[i]=0;
            int zhishu = 1;
            for(int j=dataString[i].length()-1; j>=0; j--){
                if(j!=(dataString[i].length()-1)){
                    zhishu = zhishu * 10;
                }
                dataInt[i] = dataInt[i] + Integer.parseInt(String.valueOf(dataString[i].charAt(j))) * zhishu;
            }
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
