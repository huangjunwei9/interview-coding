package com.wanmeishijie;

import java.util.Scanner;

/**
 * @Author �ƾ���
 * @create 2019/8/23 19:23
 * @email hjunwei@foxmail.com
 */
public class Dijks {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int [][] G;
        String lineString = scanner.nextLine();
        String [] a = lineString.split(" ");
        G = new int[a.length][a.length];

        //��һ���ڵ����������нڵ�Ĵ��;���
        for (int i=0 ; i<a.length; i++){
            G[0][i] = Integer.parseInt(a[i]);
        }

        //�����һ��֮��Ľڵ�
        for(int index = 1; scanner.hasNext(); index++){
            String [] b = scanner.next().split(" ");

            //��index���ڵ����������нڵ�Ĵ��;���
            for (int i=0 ; i<a.length; i++){
                G[index][i] = Integer.parseInt(a[i]);
            }
        }


        int v0=0;
        boolean[][] P=new boolean[a.length][a.length];
        int[] D=new int[a.length];

        ShortestPast_DIJ(G, v0, P, D);
        printD(D);

    }


    public static void ShortestPast_DIJ(int[][] G,int v0,boolean[][] P,int[] D)
    {
        int v,w;
        boolean[] f=new boolean[G.length];

        for(v=0;v<G.length;++v)
        {
            f[v]=false; D[v]=G[v0][v];
            for(w=0;w<G.length;++w) P[v][w]=false; //���·��
            if(D[v]<Integer.MAX_VALUE)
            {
                P[v][v0]=true;
                P[v][v]=true;
            }
        }
        D[v0]=0; f[v0]=true;  //��ʼ����v0��������S����
        //��ʼ��ѭ����ÿ�ξɵ�v0��ĳ������v�����·��������v��S��
        for(int i=1;i<G.length;++i) //����G.length-1������
        {
            int min=Integer.MAX_VALUE;
            for(w=0;w<G.length;++w)
            {
                if(!f[w])		//w������V-S��
                    if(D[w]<min)    //w������v0�������
                    {
                        v=w; min=D[v];
                    }
            }
            f[v]=true;		//��v0�����v����S��
            for(w=0;w<G.length;++w)   //���µ�ǰ���·��������
            {
                if(!f[w]&&(min+G[v][w]<D[w])&&min<Integer.MAX_VALUE&&G[v][w]<Integer.MAX_VALUE)   //�޸�D[w]��P[w],w����V-S
                {
                    D[w]=min+G[v][w];
                    P[w]=P[v].clone();
                    P[w][w]=true; //P[w]=P[v]+P[w]
                }
            }
        }
    }

    public static void printD(int[] D)
    {
        System.out.println("�յ�"+"\t���·������");
        for(int i=0;i<D.length;i++)
        {
            if(D[i]<Integer.MAX_VALUE)
                System.out.println(i+"\t"+D[i]);
            else
                System.out.println(i+"\t��");
        }

    }



}
