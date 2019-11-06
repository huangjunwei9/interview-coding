package com.jianzhioffer;

import java.util.*;
import java.util.List;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如给出数组{3,4,5,1,2} （为{1,2,3,4,5}的一个旋转），输出该数组的最小值1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
public class Answer6 implements AnswerBase {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * */
    public static void main(String [] args){
        Answer6 answer6 = new Answer6();
        answer6.printMain();
    }

    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        Integer [] array = {3,4,5,1,2};
        System.out.println("采用方法一，输出旋转数组中的最小数是：" + minNumberInRotateArray(array));
        System.out.println("采用二分法，输出旋转数组中的最小数是：" + dichotomy(array));
    }

    /** 方法1，不建议使用：
     * 1.如果array[i]大于array[i+1]，则输出array[i+1]
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
                if(i == array.length-2){//表示没有旋转
                    return array[0];
                }
            }
        }
        return -1;
    }

    /** 方法2：
     * 二分法查找 最小数的位置
     * */
    private Integer dichotomy(Integer[] array) {
        int low = 0;
        int high = array.length-1; //下标
        int mid = 0;

        /* 如果中间数大于高位数，则最小数在右边，使low = mid + 1；
         * 如果中间数小于高位数，则最小数在左边或者是mid处的值，使high = mid；
         * 如果中间数等于高位数，array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边还是右边，只能一个一个试探，使high = high - 1
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
