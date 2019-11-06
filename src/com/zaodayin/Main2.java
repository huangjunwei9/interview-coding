package com.zaodayin;



public class Main2{
    public static void main(String[] args){
        int bai,shi,ge;
        int max = 1000;
        for(int x = 100;x < max;x++){
            bai = x /100;
            shi = x % 100 /10;
            ge = x %10;
            if(bai*bai*bai + shi*shi*shi + ge*ge*ge == x){
                System.out.println(x);
            }
        }
    }
}
