package com.jianzhioffer;

import java.util.*;
import java.util.List;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * �����������{3,4,5,1,2} ��Ϊ{1,2,3,4,5}��һ����ת����������������Сֵ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * */
public class Answer6 implements AnswerBase {

    /**
     * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
     * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
     * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
     * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
     * */
    public static void main(String [] args){
        Answer6 answer6 = new Answer6();
        answer6.printMain();
    }

    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        Integer [] array = {3,4,5,1,2};
        System.out.println("���÷���һ�������ת�����е���С���ǣ�" + minNumberInRotateArray(array));
        System.out.println("���ö��ַ��������ת�����е���С���ǣ�" + dichotomy(array));
    }

    /** ����1��������ʹ�ã�
     * 1.���array[i]����array[i+1]�������array[i+1]
     * 2.
     * */
    private Integer minNumberInRotateArray(Integer[] array) {
        List<Integer> list = new LinkedList<Integer>();
        for(int i=0; i <= array.length-1; i++){
            list.add(array[i]);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        if(array.length == 0){
            return 0;
        }

        if(array.length == 1){
            return array[0];
        }

        for(int i=0; i <= array.length-2; i++){
            if(array[i] > array[i+1]){
                return array[i+1];
            }
            else{ //(array[i] <= array[i+1])
                if(i == array.length-2){//��ʾû����ת
                    return array[0];
                }
            }
        }
        return -1;
    }

    /** ����2��
     * ���ַ����� ��С����λ��
     * */
    private Integer dichotomy(Integer[] array) {
        int low = 0;
        int high = array.length-1; //�±�
        int mid = 0;

        /* ����м������ڸ�λ��������С�����ұߣ�ʹlow = mid + 1��
         * ����м���С�ڸ�λ��������С������߻�����mid����ֵ��ʹhigh = mid��
         * ����м������ڸ�λ����array���� [1,0,1,1,1] ����[1,1,1,0,1]����ʱ��С���ֲ����ж���mid��߻����ұߣ�ֻ��һ��һ����̽��ʹhigh = high - 1
         */
        while(low < high){
            mid = low + (high - low)/2;

            if(array[mid] > array[high]){
                low = mid + 1;
            }
            else if(array[mid] < array[high]){
                high = mid;
            }
            else if(array[mid] == array[high]){
                high = high - 1;
            }
        }
        return array[low];
    }

}
