package com.didi;

import java.util.Scanner;

/**
 * @Author �ƾ���
 * @email hjunwei@foxmail.com
 */

//�����������£�
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Main {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        removeDuplicates(listNode1);
        ListNode tempNode = listNode1;
        while(tempNode != null){
            tempNode = tempNode.next;
            System.out.println(tempNode.val);
        }
    }

    public static void removeDuplicates(ListNode head) {

        ListNode preNode = null;
        ListNode curNode = head;
        int time = 1;
        while(curNode != null){
            if(curNode == head){
                preNode = curNode;
                curNode = curNode.next;
                continue;
            }

            //��ǰ�ڵ�ֵ�Ƿ����ǰһ���ڵ㣬�ǣ���time++���ж�time�Ƿ�>=3���ǣ����ǰһ���ڵ�ָ��ǰ�ڵ����һ���ڵ�
            if(curNode.val == preNode.val){
                time++;
                if(time >= 3){
                    time--;
                    preNode.next = curNode.next;
                    curNode = curNode.next;
                }
            } else {
                time = 1;
                preNode = curNode;
                curNode = curNode.next;
            }


        }
    }
}


