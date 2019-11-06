package com.sort;

public class QuickSort {
    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

        /* 实现 快速排序 */
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(data, 0, data.length-1);
        System.out.print("\n快速排序结果：");
        for(int i=0; i<data.length; i++){
            System.out.print(data[i] + "->");
        }
    }


    //快排
    public void quickSort(int [] data, int low, int high) {
        int i = low;
        int j = high;
        int index = data[i];
        if(low >= high){
            return;
        }

        while(i<j){
            //从右往左扫描，直到右值小于基准值，才停止循环
            while(i<j && data[j]>=index ){
                j--;
            }
            //把右值data[j]赋值给左值data[i]
            if(i<j){
                data[i]=data[j];
                i++;
            }

            //从左往右扫描，直到左值大于或等于基准值，才停止循环
            while(i<j && data[i]<index ){
                i++;
            }
            //把左值data[i]赋值给右值data[j]
            if(i<j){
                data[j]=data[i];
                j--;
            }
        }

        data[i]=index;//此时data[i]前面的数都比index小，data[i]后面的数都比index大

        quickSort(data,low,i-1);     //对data[i]的左边重新进行快排

        if( i < (data.length-1 )) {         //对data[i]的右边重新进行快排
            quickSort(data, i + 1, high);
        }
    }

}
