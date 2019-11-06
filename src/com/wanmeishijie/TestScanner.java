package com.wanmeishijie;

import java.util.Scanner;

/**
 * @Author »Æ¾üÍþ
 * @create 2019/8/23 22:11
 * @email hjunwei@foxmail.com
 */
public class TestScanner {
    public int x = 1;
    public static void main(String [] args){
        TestScanner b = null;
        b.a();
        b.c();
        b.x = 2;
        System.out.println(b.x);
    }

    public static void a(){
        System.out.println("a");
    }

    public  void c(){
        System.out.println("c");
    }
}
