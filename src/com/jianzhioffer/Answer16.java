package com.jianzhioffer;

/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * */
public class Answer16 implements AnswerBase {
    /**
     * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
     *
     * �����˺ܾòŵõ���ȷ������ǵö࿴���⣩
     * */
    public static void main(String [] args){
        Answer16 answer16 = new Answer16();
        answer16.printMain();
    }

    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        ListNode head1=new ListNode(1);
        ListNode second1=new ListNode(3);

        ListNode head2=new ListNode(0);
        ListNode second2=new ListNode(4);
        ListNode third2=new ListNode(8);

        head1.nextNode=second1;

        head2.nextNode=second2;
        second2.nextNode=third2;

        ListNode result= mergeListNode(head1, head2);

        //������������������
        while(result != null){
            System.out.println(result.data);
            result = result.nextNode;
        }

    }


    /** �ϲ�����head1��head2
     * ˼·��
     * 1.ÿ�������������ʱ����Ҫ�Ƚ�head1��head2��ǰ�ڵ�������ĸ���С����С�Ĳ��뵽������nowNode��0�����磬nowNode.next = ����
     * 2.
     * 3.���head1��head2�е��κ�һ���������һ���ڵ�Ϊ��ʱ���Ѳ�Ϊ�յ�������������ݲ��뵽�������У�������ɡ�
     * */
    private ListNode mergeListNode(ListNode head1, ListNode head2) {

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        //��ͷ����ʼ����������������ָ��Ϊ�ڵ�
        ListNode nowNode = null;  //�������ָ��
        ListNode newHead = null;  //���ڱ����������ͷ��
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                if(newHead == null){
                    newHead = nowNode = head1;
                }else {
                    nowNode.nextNode = head1;
                    nowNode = nowNode.nextNode;
                }
                head1 = head1.nextNode;

            }else{
                if(newHead == null){
                    newHead = nowNode = head2;
                }else {
                    nowNode.nextNode = head2;
                    nowNode = nowNode.nextNode;
                }
                head2 = head2.nextNode;
            }
        }

        //��ʱ��head1����head2�Ѿ���ӵ��������У�ֻ��Ҫ��ʣ�µ�һ�������ȫ��������ӵ����������
        if(head1 == null){
            nowNode.nextNode = head2;
        }else{
            nowNode.nextNode = head1;
        }

        return newHead;
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
