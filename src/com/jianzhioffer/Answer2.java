package com.jianzhioffer;

import java.util.Scanner;

/**
 * ��Ŀ���滻�ո�
 * ��Ŀ˵������ʵ��һ�����������ַ����е�ÿ���ո��滻��?%20?����������?We are
 happy.",�����?We%20are%20happy."��
 * ����˼·�������ѭ���жϽ�һ�����鸴�Ƶ���һ�������У������ո���滻������
 �����Ƚϴ���õķ����ǣ���֪ԭ����ַ���Ŀ�Ϳո�
 * ������滻������Ҫ�Ŀռ䣨���ڵĿռ�=ԭ���Ŀռ�+2*�ո�ĸ���������ԭ�пռ�
 �Ļ����ϴӺ���ǰ���и���(ǰ����ԭ�пռ��㹻)�������ո���滻��ֱ����һ���ַ�?W?
 ������
 */
public class Answer2 {
    /**
     * ��Ŀ2���滻�ո�
     * ��Ŀ˵������ʵ��һ�����������ַ����е�ÿ���ո��滻��?%20?����������?We are happy.",�����?We%20are%20happy."��
     * ����˼·�������ѭ���жϽ�һ�����鸴�Ƶ���һ�������У������ո���滻�����������Ƚϴ�
     * ��õķ����ǣ���֪ԭ����ַ���Ŀ�Ϳո񣬼�����滻������Ҫ�Ŀռ䣨���ڵĿռ�=ԭ���Ŀռ�+2*�ո�ĸ���������ԭ�пռ�
     * �Ļ����ϴӺ���ǰ���и���(ǰ����ԭ�пռ��㹻)�������ո���滻��ֱ����һ���ַ�W ������
     */
    //����ע�����String��final���ͣ�
    public static void main(String [] args){
        System.out.println("������һ�����ո���ַ�����");
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
    * ����1��ʹ��StringBuffer��StringBuffer�Ǳ���������final���ͣ������̰߳�ȫ�ģ���Ϊ��ʹ��synchronized�ؼ���
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
     * ����2��
     * */


}
