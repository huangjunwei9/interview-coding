package com.jianzhioffer;

/**   1 2 3 4 5 6 7 8 9   -----> 1 3 5 7 9   2 4 6 8
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class Answer13 implements  AnswerBase {
    /**   1 2 3 4 5 6 7 8 9   -----> 1 3 5 7 9   2 4 6 8
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * */
    public static void main(String [] args){
        Answer13 answer13 = new Answer13();
        answer13.printMain();
    }

    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        int [] array = {1,2,3,5,6,7};
        System.out.println(reOrderArray(array));
    }

    /** 冒泡法
     * 1.如果当前数是奇数，前一个是偶数，则交换位置
     * 2.否则不变
     * @param array
     * @return
     */
    private int [] reOrderArray(int[] array) {
        int i = 0;
        int j = 0;
        int temp = 0;
        if(array.length == 0){
            System.out.println("数组为空，请键入正确格式的int数组");
            return array;
        }
        for(i=0; i<array.length; i++){
            for(j = array.length-1; j>i; j--){
                if( ((array[j] & 1) ==1) && ((array[j-1] & 1) == 0)){//前偶后奇，交换
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
}
