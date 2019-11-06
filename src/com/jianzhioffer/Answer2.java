package com.jianzhioffer;

import java.util.Scanner;

/**
 * 题目：替换空格
 * 题目说明：请实现一个函数，把字符串中的每个空格替换成?%20?。例如输入?We are
 happy.",则输出?We%20are%20happy."。
 * 解题思路：如果是循环判断将一个数组复制到另一个数组中，遇到空格就替换，这样
 开销比较大。最好的方法是，已知原理的字符数目和空格，
 * 计算出替换后所需要的空间（现在的空间=原来的空间+2*空格的个数），在原有空间
 的基础上从后往前进行复制(前提是原有空间足够)，遇到空格就替换，直到第一个字符?W?
 结束。
 */
public class Answer2 {
    /**
     * 题目2：替换空格
     * 题目说明：请实现一个函数，把字符串中的每个空格替换成?%20?。例如输入?We are happy.",则输出?We%20are%20happy."。
     * 解题思路：如果是循环判断将一个数组复制到另一个数组中，遇到空格就替换，这样开销比较大。
     * 最好的方法是，已知原理的字符数目和空格，计算出替换后所需要的空间（现在的空间=原来的空间+2*空格的个数），在原有空间
     * 的基础上从后往前进行复制(前提是原有空间足够)，遇到空格就替换，直到第一个字符W 结束。
     */
    //考点注意事项，String是final类型，
    public static void main(String [] args){
        System.out.println("请输入一串带空格的字符串：");
        Scanner scanner = new Scanner(System.in);
        String stringOriginal = scanner.nextLine();

        try {
            Class cs = Class.forName("com.jianzhioffer.Answer2");
            Answer2 answer2 = (Answer2) cs.newInstance();
            String stringBack = answer2.replaceBlank(stringOriginal);

            System.out.println(stringBack);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }




    /*
    * 方法1：使用StringBuffer。StringBuffer是变量，不是final类型；它是线程安全的，因为它使用synchronized关键字
    * */
    public String replaceBlank(String stringOriginal){
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0; i<stringOriginal.length(); i++){
            if(stringOriginal.charAt(i) != ' '){
                stringBuffer = stringBuffer.append(stringOriginal.charAt(i));
            }else{
                stringBuffer = stringBuffer.append("%20");
            }
        }
        return stringBuffer.toString();
    }

    /*
     * 方法2：
     * */


}
