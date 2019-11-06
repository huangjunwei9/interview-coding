package com.ByteDance20190818;

import java.util.Scanner;

/**
 * @Author 黄军威
 * @create 2019/8/18 15:12
 * @email hjunwei@foxmail.com
 */
public class ThirdQuestion {
    /**
     给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
     区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。
     如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
     [6] = 6 * 6 = 36;
     [2] = 2 * 2 = 4;
     [1] = 1 * 1 = 1;
     [6,2] = 2 * 8 = 16;
     [2,1] = 1 * 3 = 3;
     [6, 2, 1] = 1 * 9 = 9;
     从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
     区间内的所有数字都在[0, 100]的范围内;
     * */
    public static void main(String srg[]) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            //输入a数组
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


            //找出b[]数组中的最大值
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
