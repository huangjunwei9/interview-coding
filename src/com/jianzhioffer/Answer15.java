package com.jianzhioffer;

/**
 * ����һ��������ת��������������ı�ͷ��
 * */
public class Answer15 implements AnswerBase {
    /**
     * ����һ��������ת��������������ı�ͷ��
     * */
    public static void main(String [] args){
        Answer15 answer15 = new Answer15();
        answer15.printMain();
    }


    /**
     * ����answer����ں���
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

        ListNode reverseHead = reverseList(head);//��ת����
        printReverseList(reverseHead); //�����ת����������������

    }



    /** ��ת����
     * ˼·��1.��ȡ��̽ڵ㣬2.ʹ��ǰ�ڵ�ָ��ǰ�̽ڵ㣬3.��ǰ�ڵ���ǰ�̽ڵ㣬4.��̽ڵ��ɵ�ǰ�ڵ�
     * */
    public ListNode reverseList(ListNode head){


        if(head == null){
            System.out.println("����Ϊ��");
            return null;
        }

        ListNode preNode = null; //ǰ�̽ڵ�
        ListNode nowNode = head; //��ǰ�ڵ�
        ListNode next = nowNode.nextNode;    //��ȡ��̽ڵ�
        ListNode reverseHead = nowNode; //��ת�ڵ�ͷ��
        //��ת��Ȼ�����
        while(next != null){
            nowNode.nextNode = preNode; //node1ָ��null��
            preNode = nowNode;
            nowNode = next;
            next = nowNode.nextNode;
        }
        nowNode.nextNode = preNode;
        reverseHead = nowNode;
        return reverseHead;
    }

    /**�����ת����������������
     * @param reverseHead
     */
    private void printReverseList(ListNode reverseHead) {
        while(reverseHead != null){
            System.out.println(reverseHead.data);
            reverseHead = reverseHead.nextNode;
        }
    }


    /**
     * ����ڵ�
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
