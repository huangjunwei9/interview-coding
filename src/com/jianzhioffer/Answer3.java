package com.jianzhioffer;

import java.util.Stack;

public class Answer3 {
    /**
     * ��Ŀ3����β��ͷ��ӡ����
     * ��Ŀ˵��������һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ��
     * ����˼·��Ҫ���β��ͷ��ӡ��������һ��ʹ�õݹ���ʵ�֣������������ö�ջʵ
     �֡��ڱ����ϵݹ����һ��ջ�ṹ��
     */
    public static void main(String [] args){
        Answer3 answer3 = new Answer3();
        answer3.printMain();

    }

    private static class NodeList { //��̬�ڲ��࣬
        private String data;
        private NodeList next;
    }

    public void printMain(){
        NodeList nodeList1 = new NodeList();
        NodeList nodeList2 = new NodeList();
        NodeList nodeList3 = new NodeList();
        nodeList1.data = "��1";
        nodeList1.next = nodeList2;
        nodeList2.data = "��2";
        nodeList2.next = nodeList3;
        nodeList3.data = "��3";

        System.out.println("����һ��������ĵ�һ���ڵ㣬�Ӻ���ǰ����õ����������Ԫ�أ�����1��");
        printStack(nodeList1);

        System.out.println("����һ��������ĵ�һ���ڵ㣬�Ӻ���ǰ����õ����������Ԫ�أ�����2��");
        printRecursion(nodeList1);
    }


    /**
     * ����1����ջ��ջ�ͳ�ջ��ʽ���
     * */
    private void printStack(NodeList nodeList1) {
        Stack<NodeList> stack = new Stack<>();

        //���������ӳ�ʼ�ڵ㿪ʼ������һ���ڵ㣬����ջ��
        while(nodeList1 != null){
            stack.push(nodeList1);
            nodeList1 = nodeList1.next;
        }

        while(stack.isEmpty() != true){ //ջΪ�ǿ�״̬�����ջ
            System.out.println(stack.pop().data);
        }
    }

    /**
     * ������÷���2���ݹ鷽ʽ
     * */
    public void printRecursion(NodeList nodeList1){
        if(nodeList1 != null) {
            printRecursion(nodeList1.next);
            System.out.println(nodeList1.data);
        }
    }


}
