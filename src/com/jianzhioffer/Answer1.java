package com.jianzhioffer;

/** ��Ŀ1����һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * */
public class Answer1 {
    /** ��Ŀ1����һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
     * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
     * */
    public static void main(String [] args){
        int target = 10;
        int [][] array = {{0,10,20},{2,12,22}};//new int [n][m];

        /* ���÷�����ƻ�ȡһ��Answer1����
         * 1.����Answer1���ֽ����ļ���
         * 2.����һ��Answer1�Ķ���answer1��
         * 3.����answer1��find()����
         * */
        try {
            Class cs = Class.forName("com.jianzhioffer.Answer1");
            Answer1 answer1 = (Answer1) cs.newInstance();
            boolean result = answer1.find(target, array);
            System.out.println("answer1��" + result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public boolean find(int target, int [][] array) {
        /* step0. ���ж�target�Ƿ��ڶ�ά����array�ķ�Χ�ڣ�������ڣ���ִ��step1�������򷵻�false��
         * step1. �ж����Ͻǵ����Ƿ����target��������ɾ�����У���Ϊ���е���С������Ҫ��target��С����ɾ�����У���Ϊ������������Ҫ��targetС
         * ���Ż��ĵط��� step1�����۰뷨���ҡ�
         * */
        //�����Сrow �� column
        int row = array.length;
        int column = array[0].length;

        if(array.length == 0){
            return false;
        }

        if(array[0].length == 0){
            return false;
        }

        if(target >= array[0][0] && target <= array[row-1][column-1]){ //target������ [��Сֵ,���ֵ] ��Χ�ڣ������������λ��
            //���ҵĳ�ʼλ��Ϊarray[startRow][startColumn]
            int startRow = 0;
            int startColumn = column-1;

            while(startRow < row && startColumn >= 0){
                if(target == array[startRow][startColumn]){
                    return true;
                }else if(target < array[startRow][startColumn]){
                    startColumn--;
                }else{
                    startRow++;
                }
            }
            return false;//�������鶼û�и�ֵ������false
        }
        else{
            return false;
        }
    }

}
