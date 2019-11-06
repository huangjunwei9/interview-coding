//package com.aiqiyi;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @Author 黄军威
// * @create 2019/9/18 19:50
// * @email hjunwei@foxmail.com
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();//n个人
//        int [] array = new int [n];//n个人进行至少array[i]轮
//        for(int i=0; i<n; i++){
//            array[i] = scanner.nextInt();
//        }
//
//        //n个人，最多需要比 sum 次
//        Arrays.sort(array);
//
////        array[1] - array[0]
////        for(int i=1; i<n; i++){
////            array[i] =
////        }
//
//
//        if(array.length > 2){
//            if( (array[0] + array[1]) >= array[array.length-1]){
//                System.out.println(array[0] + array[1]);
//            }else{
//                System.out.println(array[array.length-1]);
//            }
//        }else{
//            System.out.println(array[0] + array[1]);
//        }
//
//
//    }
//}
package com.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 黄军威
 * @create 2019/9/18 19:50
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//n个人
        int [] array = new int [n];//n个人进行至少array[i]轮
        for(int i=0; i<n; i++){
            array[i] = scanner.nextInt();
        }

        //n个人，最多需要比 sum 次
        Arrays.sort(array);

        int dec = array[1] - array[0];
        for(int i=1; i<n; i++){
            array[i] = array[i] - dec;
        }
        Arrays.sort(array);

        if(array.length > 2){
            if( (array[0] + array[1]) >= array[array.length-1]){
                System.out.println(array[0] + array[1]);
            }else{
                System.out.println(array[array.length-1]);
            }
        }else{
            System.out.println(array[0] + array[1]);
        }


    }
}
