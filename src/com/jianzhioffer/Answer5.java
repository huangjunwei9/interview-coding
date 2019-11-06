package com.jianzhioffer;

import java.util.Stack;

/**
 *������ջ��ʵ��һ�����У����м��ѣ�����ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class Answer5 implements AnswerBase {

    /**
     *������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
     */
    public static void main(String [] args){
        Answer5 answer5 = new Answer5();
        answer5.printMain();
    }

    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        while(!myQueue.isEmpty()){
            System.out.println(myQueue.pop());
        }

    }

    /* ˼·��
     * 1.
     *
     * */
     class MyQueue{
        Stack<Integer> stack1 = new Stack<Integer>();//����push
        Stack<Integer> stack2 = new Stack<Integer>();//����pop

        //�����
        public synchronized void push(Integer data){
            stack1.push(data);
        }

        //�����С����stack2���ˣ��Ͱ�stack1������Ԫ��pop��ջ push��stack2�У�ֱ��stack1��Ϊ�ա����stack2��Ϊ�գ��򷵻�Integer.MAX_VALUE������pop��stack2�Ķ�Ԫ�أ������ظ�ֵ
        public synchronized Integer pop(){
            if(stack2.isEmpty() == true){
                while(stack1.isEmpty() == false){ //ֱ��stack1��Ϊ��
                    stack2.push(stack1.pop());
                }
            }

            if(!stack2.isEmpty()){
                return stack2.pop();
            }
            else{
                return Integer.MAX_VALUE;
            }
        }

        //�жϸö����Ƿ�Ϊ��
        public boolean isEmpty(){
            if(stack1.isEmpty() && stack2.isEmpty()){
                return true;
            }
            return false;
        }


    }





}


















