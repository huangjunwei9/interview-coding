package com.jianzhioffer;

/**
 * ����һ����������������е�����k����㡣
 * */
public class Answer14 implements AnswerBase {
    /**
     * ����һ����������������е�����k����㡣
     * */
    public static void main(String [] args){
        Answer14 answer14 = new Answer14();
        answer14.printMain();
    }


    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();

        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;

        head.nextNode = second;
        second.nextNode = third;
        third.nextNode = forth;

        //���������4���ڵ�
        ListNode result = findKthToTail(head, 4);//���������4���ڵ�洢����
        if(result != null){
            System.out.println("��4���ڵ�洢�����ǣ�" + result.data);
        }else{
            System.out.println("�������ڻ���Ҫ��ѯ�Ľڵ㲻����");
        }

        //���������5���ڵ�
        result = findKthToTail(head, 5);//���������5���ڵ�洢����
        if(result != null){
            System.out.println(result.data);
        }else{
            System.out.println("�������ڻ���Ҫ��ѯ�Ľڵ㲻����");
        }
    }


    /** ��������ͷ���ڵ�list������������е�����k����㡣
     * ˼·��ʹ��������������A��B������A����k����Ȼ��B��ʼ�ߣ���A�ߵ�����β��ʱA��nextNodeΪ�գ���ʱB��ΪĿ��ڵ㣬���B�ڵ������
     * 1.pre����k����i��ʾ����
     * 2.������ߵĽڵ����һ���ڵ���null����ôaft�ڵ����Ŀ��ڵ㣬������ѭ��
     * 3.���������k���ڵ㲻���ڣ�Ҳ����ѭ��
     * */
    public ListNode findKthToTail(ListNode list,int k){
        if(list == null || k == 0){
            System.out.println("�������ڻ���Ҫ��ѯ�Ľڵ㲻����");
            return null;
        }

        ListNode pre = list;//���ߵĽڵ�
        ListNode aft = list;//���ߵĽڵ�
        int i = 0;
        for( ; pre != null; i++){
            pre = pre.nextNode;
            if(i >= k){
                aft = aft.nextNode;
            }
        }

        if(i<k){
            System.out.println("�����ڵ�����k���ڵ�");
            return null;
        }
        return aft;
    }


    /**
     * ����ڵ�
     * */
    public class ListNode {
        int data;
        ListNode nextNode = null;

        ListNode() {
        }

        ListNode(int val) {
            this.data = val;
        }
    }

}
