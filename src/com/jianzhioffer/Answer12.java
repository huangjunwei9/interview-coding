package com.jianzhioffer;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η� base ^ exponent��
 *
 * ���� ���򵥿������㷨���������ݿ��Բο�https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E5%B9%82/5500243?fr=aladdin
 * */
public class Answer12 implements AnswerBase {
    /**
     * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
     * */
    public static void main(String [] args){
        Answer12 answer12 = new Answer12();
        answer12.printMain();
    }

    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        double base = 5;
        int exponent = 90;
        System.out.println( base + " ^ " + exponent + " = " + powerOperation(base, exponent));
    }

    /** ע�⣺
     * exponent = 0ʱ�����1
     * base = 1ʱ�����1
     *
     * base = 0��exponent > 0ʱ�����0
     * base = 0, exponent < 0ʱ��������쳣������Ϊ0ʱ��ָ������С��0��
     *
     * ��exponent�ǳ���ʱ��û�б�Ҫһ��һ�����㣬���Բ��ö��ִ洢�����㡣
     * ���統base =5, exponent = 100ʱ�������ȼ���� 5^2���ټ����5^4��
     * �ټ����5^8��5^16��5^32��5^64��5^96 = (5^32) * (5^64)��
     * �������5^100 = (5^96) * (5^4)��
     *
     * @param base
     * @param exponent
     * @return
     */
    private double powerOperation(double base, int exponent) {
        double result = 1.0;

        if(exponent == 0){
            result = 1.0;
            return result;
        }
        if(base == 1){
            result = 1.0;
            return result;
        }

        if(base == 0 && exponent >0){
            result = 0.0;
            return result;
        }
        if(base == 0 && exponent <0){
            System.out.println("�쳣������Ϊ0ʱ��ָ������С��0");
            return Float.MAX_VALUE;
        }

        if(exponent > 0){
            result = powerOperationOverZero(base, exponent);
        }
        if(exponent < 0){
            result = 1.0/powerOperationOverZero(base, exponent) ;
        }
        return result;
    }


    //�򵥿������㷨
    /** ����int exponent > 0ʱ��base��exponent�η�����ʱ����ֵ�ز�����0
     * �������򵥿������㷨�������ö����Ƽ����exponent = 2^a1 + 2^a2 + 2^a3 + ...�е�a1, a2, a3, ...
     * ���磬��5^90��ͨ�������������֪��90 = 2^6 + 0 + 2^4 + 2^3 + 0 + 2^1 + 0 = 0101 1010 (2����)
     * ��5^90 = 1.0 * (5^2) * (5^8) * (5^16) * (5^64)������base���ݱ����
     * base = 5,
     * base = base * base = 5^2,
     * base = base * base = 5^4
     * base = base * base = 5^8
     * base = base * base = 5^16
     * base = base * base = 5^32
     * base = base * base = 5^64
     * */
    private double powerOperationOverZero(double base, int exponent) {
        double result = 1.0;
        while(exponent != 0){
            //������λ����1Ϊ�棬��ʹresult = result * base
            if((exponent & 1) != 0) {
                result = result * base;  //result = 1 * base *
            }
            //�������λ�Ƿ�Ϊ1������base = base * base
            base = base * base;
            exponent >>= 1; //����1λ��������2
        }
        return  result;
    }


}














