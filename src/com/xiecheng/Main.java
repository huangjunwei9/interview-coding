package com.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*������������������ʵ����ĿҪ��Ĺ���
    ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
    ******************************��ʼд����******************************/
    /*
    * �೧�����е����ݿ������һ�ײ�ѯ���ʽ����������ʽ�����ű�ʾ��������ַ�����ת���������ʵ����һ�߼�
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

    /******************************����д����******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);   //����
        System.out.println(res);
    }
}

