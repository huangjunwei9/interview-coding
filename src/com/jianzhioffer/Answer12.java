package com.jianzhioffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方 base ^ exponent。
 *
 * 考察 “简单快速幂算法”，快速幂可以参考https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E5%B9%82/5500243?fr=aladdin
 * */
public class Answer12 implements AnswerBase {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * */
    public static void main(String [] args){
        Answer12 answer12 = new Answer12();
        answer12.printMain();
    }

    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        double base = 5;
        int exponent = 90;
        System.out.println( base + " ^ " + exponent + " = " + powerOperation(base, exponent));
    }

    /** 注意：
     * exponent = 0时，输出1
     * base = 1时，输出1
     *
     * base = 0，exponent > 0时，输出0
     * base = 0, exponent < 0时，输出“异常，基数为0时，指数不能小于0”
     *
     * 当exponent非常大时，没有必要一步一步计算，可以采用二分存储来计算。
     * 比如当base =5, exponent = 100时，可以先计算出 5^2，再计算出5^4，
     * 再计算出5^8，5^16，5^32，5^64，5^96 = (5^32) * (5^64)，
     * 最后计算出5^100 = (5^96) * (5^4)。
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
            System.out.println("异常，基数为0时，指数不能小于0");
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


    //简单快速幂算法
    /** 计算int exponent > 0时，base的exponent次方，此时返回值必不等于0
     * 方法：简单快速幂算法，即利用二进制计算出exponent = 2^a1 + 2^a2 + 2^a3 + ...中的a1, a2, a3, ...
     * 比如，求5^90，通过二进制运算可知：90 = 2^6 + 0 + 2^4 + 2^3 + 0 + 2^1 + 0 = 0101 1010 (2进制)
     * 则5^90 = 1.0 * (5^2) * (5^8) * (5^16) * (5^64)，其中base的演变过程
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
            //如果最低位等于1为真，则使result = result * base
            if((exponent & 1) != 0) {
                result = result * base;  //result = 1 * base *
            }
            //不管最低位是否为1，都做base = base * base
            base = base * base;
            exponent >>= 1; //右移1位，即除以2
        }
        return  result;
    }


}














