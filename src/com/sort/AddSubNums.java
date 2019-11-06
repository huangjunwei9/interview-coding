package com.sort;

import java.util.Scanner;

public class AddSubNums {

    public static void main(String [] args){
        int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

        /* ������������ */
        AddSubNums addSubNums = new AddSubNums();
        addSubNums.AddSubNumsMain();
    }


    public void AddSubNumsMain(){
        /* ������������ */
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        //��¼ÿ��λ������������еĳ���
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;//���۴Ӻδ���ʼ�����ȶ�����Ϊ1
            for (int j = 0; j < i; j++) {
                //�����iλ�ô���jλ�ã�����jλ�õ�����������еĳ���+1 ���� Ŀǰiλ�õ�����������еĳ��ȣ������iλ�õ������������
                if (nums[j] <= nums[i] &&
                        result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i : result){ //i����ȡresult�е�ֵ����result�е����ֵ
            if(i > max ){
                max = i;
            }

        }
        System.out.println(max);

    }

}
