package com.sort;

//import com.friendlyp.FriendlyClass; //����һ���Ѻ��࣬�����ڲ�ͬ���е���

/* �鲢���� */
public class MergeSort {

    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};
        System.out.println((9+2)/2);

        /* �鲢���� */
        MergeSort mergeSort = new MergeSort();
        mergeSort.printSortMain();
    }

    public void printSortMain() {
        int i = 0;
        int [] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2, 10};
        int len = a.length;

        mergeSort(a, 0, len-1);
        System.out.print("\n�鲢��������");
        for(i = 0; i<len; i++){
            System.out.print(a[i] + "->");
        }

    }

    private void mergeSort(int[] array, int p, int r) {
        if( p < r){
            int q = (p + r)/2;
            mergeSort(array, p, q);
            mergeSort(array,q+1, r);
            merge(array,p,q,r);  //�ϲ���������array[p]~array[q]�� array[q+1]~array[r]Ϊһ����������
        }

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int i= low;
        int j = mid+1;
        int k=0;
        int[] temp = new int[high-low+1];

        // �ѽ�С�������Ƶ���������
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
        // �����ʣ�������������
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // ���ұ߱�ʣ�������������
        while(j<=high){
            temp[k++] = a[j++];
        }
        // ���������е�������nums����
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }


}
