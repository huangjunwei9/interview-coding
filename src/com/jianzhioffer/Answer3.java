package com.jianzhioffer;

import java.util.Stack;

public class Answer3 {
    /**
     * 题目3：从尾到头打印链表
     * 题目说明：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
     * 解题思路：要想从尾到头打印链表，方法一：使用递归来实现；方法二：采用堆栈实
     现。在本质上递归就是一个栈结构。
     */
    public static void main(String [] args){
        Answer3 answer3 = new Answer3();
        answer3.printMain();

    }

    private static class NodeList { //静态内部类，
        private String data;
        private NodeList next;
    }

    public void printMain(){
        NodeList nodeList1 = new NodeList();
        NodeList nodeList2 = new NodeList();
        NodeList nodeList3 = new NodeList();
        nodeList1.data = "张1";
        nodeList1.next = nodeList2;
        nodeList2.data = "张2";
        nodeList2.next = nodeList3;
        nodeList3.data = "张3";

        System.out.println("给出一个单链表的第一个节点，从后往前输出该单链表的所有元素，方法1：");
        printStack(nodeList1);

        System.out.println("给出一个单链表的第一个节点，从后往前输出该单链表的所有元素，方法2：");
        printRecursion(nodeList1);
    }


    /**
     * 方法1：用栈入栈和出栈方式解决
     * */
    private void printStack(NodeList nodeList1) {
        Stack<NodeList> stack = new Stack<>();

        //遍历链表，从初始节点开始，有下一个节点，则入栈。
        while(nodeList1 != null){
            stack.push(nodeList1);
            nodeList1 = nodeList1.next;
        }

        while(stack.isEmpty() != true){ //栈为非空状态，则出栈
            System.out.println(stack.pop().data);
        }
    }

    /**
     * 建议采用方法2：递归方式
     * */
    public void printRecursion(NodeList nodeList1){
        if(nodeList1 != null) {
            printRecursion(nodeList1.next);
            System.out.println(nodeList1.data);
        }
    }


}
