package com.sort;

//import com.friendlyp.FriendlyClass; //这是一个友好类，不能在不同包中导入

/* 归并排序 */
public class MergeSort {

    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};
        System.out.println((9+2)/2);

        /* 归并排序 */
        MergeSort mergeSort = new MergeSort();
        mergeSort.printSortMain();
    }

    public void printSortMain() {
        int i = 0;
        int [] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2, 10};
        int len = a.length;

        mergeSort(a, 0, len-1);
        System.out.print("\n归并排序结果：");
        for(i = 0; i<len; i++){
            System.out.print(a[i] + "->");
        }

    }

    private void mergeSort(int[] array, int p, int r) {
        if( p < r){
            int q = (p + r)/2;
            mergeSort(array, p, q);
            mergeSort(array,q+1, r);
            merge(array,p,q,r);  //合并两个数组array[p]~array[q]， array[q+1]~array[r]为一个有序数组
        }

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int i= low;
        int j = mid+1;
        int k=0;
        int[] temp = new int[high-low+1];

        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){//0~5,6~10
            if(a[i]<a[j]){
                temp[k] = a[i];
                i++;
            }else{
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }


}
