package com.test;

/**
 * @Author »Æ¾üÍş
 * @create 2019/8/23 0:40
 * @email hjunwei@foxmail.com
 */
public class Test {

    public static Test t1=new Test();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args){
        Test t2=new Test();
    }
}
