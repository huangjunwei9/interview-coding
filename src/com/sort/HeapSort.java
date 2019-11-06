package com.sort;

/**
 * @Author 黄军威
 * @create 2019/9/2 0:39
 * @email hjunwei@foxmail.com
 */
//堆排序
public class HeapSort {
    private static int len;
    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

        /* 实现 堆排序，使 */
        heapSort(data);
    }

    public static int [] heapSort(int [] array){
        len = array.length;
        if(len<1){
            return  array;
        }

        //构建一个最大堆；
        for(int i=(len-1)/2; i>=0; i--){
            adjustHeap(array,i);
        }

        //循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while(len>1){
            swap(array, 0, len-1);
            len--;
            adjustHeap(array, 0);
        }

        return array;
    }

    //将堆首位（最大值）与末位交换
    private static void swap(int[] array, int i, int j) {
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }

    /** 调整使array成为最大堆 * */
    private static void adjustHeap(int[] array, int i) {
        int maxIndex = i;

        //如果有左子树，且左子树大于父节点，则将最大自增指向左子树
        if(i*2 < len && array[i*2] > array[maxIndex]){
            maxIndex = i*2;
        }
        //如果有右子树，且右子树大于父节点，则将最大自增指向右子树
        if(i*2+1 < len && array[i*2+1] > array[maxIndex]){
            maxIndex = i*2 + 1;
        }
        //如果父节点不是最大值，这将父节点与最大值交换，并且递归调整与父节点交换的位置
        if(maxIndex != i){
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }

    }


}















