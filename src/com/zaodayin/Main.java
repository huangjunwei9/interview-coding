package com.zaodayin;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        //t������
        for(int ti=0; ti<t; ti++){
            int n = scanner.nextInt();
            int [] array = new int [n];
            int [] sumArray = new int [n];

            //�������飬���� ��ǰ��+ǰ���������� �ĺ͵õ�sumArray[i]
            for(int i=0; i<n; i++){
                array[i] = scanner.nextInt();
                if(i>0){
                    sumArray[i] = sumArray[i-1] + array[i];
                }else{
                    sumArray[i] = array[i];
                }
            }

            //�ų�n==1�����
            if(n<=1){
                System.out.println(0);
                continue;
            }

            int a = (int)Math.pow(1,2);

            //ÿ��λ�õ��������
            int [] resultArray = new int[n];

            for(int i=1; i<n; i++){
                int result = 1;
                for(int j=i+1; j<n; j++){
                    //���⴦��
//                    if(j == 1){
//                        if(array[1] > array[0]){
//                            result++;
//                            continue;
//                        }else{
//                            break;
//                        }
//                    }

                    if(array[j] >= (sumArray[j-1] - sumArray[i-1])    ){
                        result++;
                    }else{
                        resultArray[i] = result;
                        break;
                    }
                }
                resultArray[i] = result;
            }
            Arrays.sort(resultArray);

            System.out.println(resultArray[n-1]);
        }//����һ������


    }
}

/***
2
5
1 3 9 2 6
5
4 2 9 16 7
*/







