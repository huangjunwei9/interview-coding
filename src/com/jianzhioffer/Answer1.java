package com.jianzhioffer;

/** 题目1：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */
public class Answer1 {
    /** 题目1：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * */
    public static void main(String [] args){
        int target = 10;
        int [][] array = {{0,10,20},{2,12,22}};//new int [n][m];

        /* 采用反射机制获取一个Answer1对象
         * 1.加载Answer1的字节码文件；
         * 2.创建一个Answer1的对象answer1；
         * 3.调用answer1的find()方法
         * */
        try {
            Class cs = Class.forName("com.jianzhioffer.Answer1");
            Answer1 answer1 = (Answer1) cs.newInstance();
            boolean result = answer1.find(target, array);
            System.out.println("answer1：" + result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public boolean find(int target, int [][] array) {
        /* step0. 先判断target是否在二维数组array的范围内，。如果在，则执行step1；不在则返回false。
         * step1. 判断右上角的数是否大于target，大于则删除该列，因为该列的最小的数都要比target大；小于则删除该行，因为该行最大的数都要比target小
         * 可优化的地方： step1采用折半法查找。
         * */
        //数组大小row × column
        int row = array.length;
        int column = array[0].length;

        if(array.length == 0){
            return false;
        }

        if(array[0].length == 0){
            return false;
        }

        if(target >= array[0][0] && target <= array[row-1][column-1]){ //target在数组 [最小值,最大值] 范围内，则继续查找其位置
            //查找的初始位置为array[startRow][startColumn]
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
            return false;//整个数组都没有该值，返回false
        }
        else{
            return false;
        }
    }

}
