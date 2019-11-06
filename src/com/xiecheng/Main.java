package com.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    /*
    * 豚厂给自研的数据库设计了一套查询表达式，在这个表达式中括号表示将里面的字符串翻转。请你帮助实现这一逻辑
    * ((ur)oi)
    * iour
    * */
    static String resolve(String expr) {
        int left = 0;
        int right =0;
        for(int i=0; i<expr.length(); i++){
            if(expr.charAt(i) == '('){
                left++;
            }else if(expr.charAt(i) == ')'){
                right++;
            }
        }
        if(left != right){
            return "";
        }

        String result = getTheString(expr);

        return result;
    }


    private static String getTheString(String expr) {



        return expr;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);   //调用
        System.out.println(res);
    }
}

