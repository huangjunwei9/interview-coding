package com.jianzhioffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * */
public class Answer15 implements AnswerBase {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * */
    public static void main(String [] args){
        Answer15 answer15 = new Answer15();
        answer15.printMain();
    }


    /**
     * 定义answer的入口函数
     */
    @Override
    public void printMain() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);

        head.nextNode = second;
        second.nextNode = third;
        third.nextNode = forth;

        ListNode reverseHead = reverseList(head);//反转链表
        printReverseList(reverseHead); //输出反转后的链表的所有数据

    }



    /** 反转链表
     * 思路：1.获取后继节点，2.使当前节点指向前继节点，3.当前节点变成前继节点，4.后继节点变成当前节点
     * */
    public ListNode reverseList(ListNode head){


        if(head == null){
            System.out.println("链表为空");
            return null;
        }

        ListNode preNode = null; //前继节点
        ListNode nowNode = head; //当前节点
        ListNode next = nowNode.nextNode;    //获取后继节点
        ListNode reverseHead = nowNode; //反转节点头部
        //反转，然后后移
        while(next != null){
            nowNode.nextNode = preNode; //node1指向null，
            preNode = nowNode;
            nowNode = next;
            next = nowNode.nextNode;
        }
        nowNode.nextNode = preNode;
        reverseHead = nowNode;
        return reverseHead;
    }

    /**输出反转后的链表的所有数据
     * @param reverseHead
     */
    private void printReverseList(ListNode reverseHead) {
        while(reverseHead != null){
            System.out.println(reverseHead.data);
            reverseHead = reverseHead.nextNode;
        }
    }


    /**
     * 定义节点
     * */
    public class ListNode {
        int data;
        ListNode nextNode = null;

        ListNode() {
            nextNode = null;
        }
        ListNode(int val) {
            this.data = val;
            nextNode = null;
        }
    }
}
