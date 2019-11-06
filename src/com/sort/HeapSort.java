package com.sort;

/**
 * @Author �ƾ���
 * @create 2019/9/2 0:39
 * @email hjunwei@foxmail.com
 */
//������
public class HeapSort {
    private static int len;
    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

        /* ʵ�� ������ʹ */
        heapSort(data);
    }

    public static int [] heapSort(int [] array){
        len = array.length;
        if(len<1){
            return  array;
        }

        //����һ�����ѣ�
        for(int i=(len-1)/2; i>=0; i--){
            adjustHeap(array,i);
        }

        //ѭ��������λ�����ֵ����ĩλ������Ȼ�������µ�������
        while(len>1){
            swap(array, 0, len-1);
            len--;
            adjustHeap(array, 0);
        }

        return array;
    }

    //������λ�����ֵ����ĩλ����
    private static void swap(int[] array, int i, int j) {
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }

    /** ����ʹarray��Ϊ���� * */
    private static void adjustHeap(int[] array, int i) {
        int maxIndex = i;

        //������������������������ڸ��ڵ㣬���������ָ��������
        if(i*2 < len && array[i*2] > array[maxIndex]){
            maxIndex = i*2;
        }
        //������������������������ڸ��ڵ㣬���������ָ��������
        if(i*2+1 < len && array[i*2+1] > array[maxIndex]){
            maxIndex = i*2 + 1;
        }
        //������ڵ㲻�����ֵ���⽫���ڵ������ֵ���������ҵݹ�����븸�ڵ㽻����λ��
        if(maxIndex != i){
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }

    }


}















