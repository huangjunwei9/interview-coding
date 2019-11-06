package com.sort;

public class QuickSort {
    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

        /* ʵ�� �������� */
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(data, 0, data.length-1);
        System.out.print("\n������������");
        for(int i=0; i<data.length; i++){
            System.out.print(data[i] + "->");
        }
    }


    //����
    public void quickSort(int [] data, int low, int high) {
        int i = low;
        int j = high;
        int index = data[i];
        if(low >= high){
            return;
        }

        while(i<j){
            //��������ɨ�裬ֱ����ֵС�ڻ�׼ֵ����ֹͣѭ��
            while(i<j && data[j]>=index ){
                j--;
            }
            //����ֵdata[j]��ֵ����ֵdata[i]
            if(i<j){
                data[i]=data[j];
                i++;
            }

            //��������ɨ�裬ֱ����ֵ���ڻ���ڻ�׼ֵ����ֹͣѭ��
            while(i<j && data[i]<index ){
                i++;
            }
            //����ֵdata[i]��ֵ����ֵdata[j]
            if(i<j){
                data[j]=data[i];
                j--;
            }
        }

        data[i]=index;//��ʱdata[i]ǰ���������indexС��data[i]�����������index��

        quickSort(data,low,i-1);     //��data[i]��������½��п���

        if( i < (data.length-1 )) {         //��data[i]���ұ����½��п���
            quickSort(data, i + 1, high);
        }
    }

}
