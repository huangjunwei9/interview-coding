package com.tenxun1;

import java.util.Scanner;

/**
 * @Author �ƾ���
 * @email hjunwei@foxmail.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        //��i��
        for(int i=0; i<t; i++){
            int len = scanner.nextInt();
            scanner.nextLine();
            String string = scanner.nextLine();
            char [] array = string.toCharArray();

            if(len != array.length){
                System.out.println("NO");
                continue;
            }

            if(len < 11){
                System.out.println("NO");
                continue;
            }

            //�ҵ���һ��8��λ��k����len-k�����len-k < 11����NO������YES��
            //���û��8�������NO
            int index = -1;
            for(int k=0; k<len; k++){
                if(array[k] == '8'){
                    index = k;
                    break;
                }
            }

            if(index == -1){
                System.out.println("NO");
                continue;
            }
            if( (len - index) < 11 ){
                System.out.println("NO");
                continue;
            }else{
                System.out.println("YES");
                continue;
            }

        }

    }
}











