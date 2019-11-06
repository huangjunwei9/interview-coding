package com.wanmeishijie;

import java.util.Scanner;

/**
 * @Author 黄军威
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

        //第一个节点与其他所有节点的传送距离
        for (int i=0 ; i<a.length; i++){
            G[0][i] = Integer.parseInt(a[i]);
        }

        //输入第一行之外的节点
        for(int index = 1; scanner.hasNext(); index++){
            String [] b = scanner.next().split(" ");

            //第index个节点与其他所有节点的传送距离
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
            for(w=0;w<G.length;++w) P[v][w]=false; //设空路径
            if(D[v]<Integer.MAX_VALUE)
            {
                P[v][v0]=true;
                P[v][v]=true;
            }
        }
        D[v0]=0; f[v0]=true;  //初始化，v0顶点属于S集合
        //开始主循环，每次旧的v0到某个顶点v的最短路径，并加v到S集
        for(int i=1;i<G.length;++i) //其余G.length-1个顶点
        {
            int min=Integer.MAX_VALUE;
            for(w=0;w<G.length;++w)
            {
                if(!f[w])		//w顶点在V-S中
                    if(D[w]<min)    //w顶点离v0顶点更近
                    {
                        v=w; min=D[v];
                    }
            }
            f[v]=true;		//离v0最近的v加入S集
            for(w=0;w<G.length;++w)   //更新当前最短路径及距离
            {
                if(!f[w]&&(min+G[v][w]<D[w])&&min<Integer.MAX_VALUE&&G[v][w]<Integer.MAX_VALUE)   //修改D[w]和P[w],w属于V-S
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
        System.out.println("终点"+"\t最短路径长度");
        for(int i=0;i<D.length;i++)
        {
            if(D[i]<Integer.MAX_VALUE)
                System.out.println(i+"\t"+D[i]);
            else
                System.out.println(i+"\t无");
        }

    }



}
