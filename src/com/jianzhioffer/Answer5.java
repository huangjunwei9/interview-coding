package com.jianzhioffer;

import java.util.Stack;

/**
 *用两个栈来实现一个队列（队列即堆），完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Answer5 implements AnswerBase {

    /**
     *用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    public static void main(String [] args){
        Answer5 answer5 = new Answer5();
        answer5.printMain();
    }

    /**
     * 定义answer的入口函数
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

    /* 思路：
     * 1.
     *
     * */
     class MyQueue{
        Stack<Integer> stack1 = new Stack<Integer>();//用于push
        Stack<Integer> stack2 = new Stack<Integer>();//用于pop

        //入队列
        public synchronized void push(Integer data){
            stack1.push(data);
        }

        //出队列。如果stack2空了，就把stack1中所有元素pop出栈 push到stack2中，直到stack1中为空。如果stack2仍为空，则返回Integer.MAX_VALUE，否则pop出stack2的顶元素，并返回该值
        public synchronized Integer pop(){
            if(stack2.isEmpty() == true){
                while(stack1.isEmpty() == false){ //直到stack1中为空
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

        //判断该队列是否为空
        public boolean isEmpty(){
            if(stack1.isEmpty() && stack2.isEmpty()){
                return true;
            }
            return false;
        }


    }





}


















