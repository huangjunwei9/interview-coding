package com.ByteDance20190818;

import java.util.Scanner;

/**
 * @Author �ƾ���
 * @create 2019/8/18 15:12
 * @email hjunwei@foxmail.com
 */
public class ThirdQuestion {
    /**
     ����һ����������, ��Ҫ��ѡ��һ������, ʹ�ø����������������о������¼����ֵ����һ����
     �����е���С�� * �����������ĺ�����������������������ֵ���ɣ�����Ҫ�����������䡣
     ���������  [6 2 1]�����������ʽ, �ɵõ����п���ѡ����������ļ���ֵ:
     [6] = 6 * 6 = 36;
     [2] = 2 * 2 = 4;
     [1] = 1 * 1 = 1;
     [6,2] = 2 * 8 = 16;
     [2,1] = 1 * 3 = 3;
     [6, 2, 1] = 1 * 9 = 9;
     ����������ɼ�ѡ������ [6] ������ֵΪ 36�� ��������Ϊ 36��
     �����ڵ��������ֶ���[0, 100]�ķ�Χ��;
     * */
    public static void main(String srg[]) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            //����a����
            for (int i = 0;i < n;i++)
            {
                a[i] = sc.nextInt();
            }

            //
            for(int i = 0;i < n;i++)
            {
                int p = i,q = i+1,sum = 0;
                while(p >=0  && a[i] <= a[p])
                {
                    sum += a[p];
                    p--;
                }
                while(q < n && a[i] <= a[q])
                {
                    sum += a[q];
                    q++;
                }
                b[i] = a[i] * sum;
            }


            //�ҳ�b[]�����е����ֵ
            int max = b[0];
            for(int i = 1;i < n;i++)
            {
                if(b[i] > max)
                    max = b[i];
            }
            System.out.println(max);
        }
    }
}
