package com.jianzhioffer;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0���� n<=39
 * */
public class Answer7 implements AnswerBase{
    /**
     * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0���� n<=39
     * */
    public static void main(String [] args){
        Answer7 answer7 = new Answer7();
        answer7.printMain();
    }

    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        int n = 39;

        long timeUse = System.currentTimeMillis();
        System.out.print("�ݹ鷨��" + Fibonacci1(n) + ", ");
        System.out.println("\n�ݹ鷨����ʱ�䣺" + (System.currentTimeMillis() - timeUse));

        timeUse = System.currentTimeMillis();
        System.out.print("ѭ������" + Fibonacci2(n) + ", ");
        System.out.println("\nѭ��������ʱ�䣺" + (System.currentTimeMillis() - timeUse));
    }

    /** ����1���ݹ鷽����ȱ�㣺ʱ��Ϳռ临�Ӷȷǳ��ߣ����������
    * f(n) = f(n-2) + f(n-1),   n>=2
    * f(n) = 1,  n=1
    * f(n) = 0,  n=0
    * */
    private int Fibonacci1(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int fn = Fibonacci1(n-1) + Fibonacci1(n-2);
        return fn;
    }

    /** ����2��ѭ�������ŵ㣺���͸��Ӷ�
     *
     * */
    private int Fibonacci2(int n) {
        int n0 = 0;
        int n1 = 1;

        if(n == 0){
            return n0;
        }
        if(n == 1){
            return n1;
        }

        int fn = 0;//���ڷ��ص�Fibonacci�еĵ�n����
        for(int i = 2;i<=n; i++){
            //�ȼ����ǰ�������ĺͣ���ʹn0��n1һ������
            fn = n0 + n1;
            n0 = n1;
            n1 = fn;
        }
        return fn;
    }

}











