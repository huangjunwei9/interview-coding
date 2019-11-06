package com.vivo;

import java.io.*;

/**
 * Welcome to vivo !
 */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        // TODO Write your code here
        int n = input[0];   //����
        int m = input[1];   //����
        int [] originArray = new int [n];
        int [] outputArray = new int [n]; //��������

        //��ʼ���˵ĺ���
        for(int i=0; i<n; i++){
            originArray[i] = i + 1;
        }

        int incData = 1;    //����123456...
        int len = n;        //��ǰ����
        int numOutput = 0;   //��ǰ��������outputArray[]�е��±�
        while(len > 0){

            //��һ��ѭ������������һ��
            for(int i=0; i<n ; i++){
                if(originArray[i] != -1){
                    //�����ǰ����ֵ������M����Ѹ�ѧ�����ӣ���ǰ����-1
                    if( (incData % m == 0)  ){
                        //�Ѹ�ѧ������
                        outputArray[numOutput] = originArray[i];
                        numOutput++;
                        //��ǰ����-1
                        originArray[i] = -1;
                        len--;
                    }
                    //ֻҪoriginArray[i] != -1�����ü���ֵ����1
                    incData++;
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer("" + outputArray[0]);

        for(int i=1; i<n; i++){
            stringBuffer.append( " " + outputArray[i]);
        }
        String result = stringBuffer.toString();

        return result;
    }

}
