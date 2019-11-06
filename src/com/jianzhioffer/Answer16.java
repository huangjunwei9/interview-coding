package com.jianzhioffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * */
public class Answer16 implements AnswerBase {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * （做了很久才得到正确结果，记得多看此题）
     * */
    public static void main(String [] args){
        Answer16 answer16 = new Answer16();
        answer16.printMain();
    }

    /**
     * 定义answer的入口函数
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

        //输出新链表的所有数据
        while(result != null){
            System.out.println(result.data);
            result = result.nextNode;
        }

    }


    /** 合并链表head1和head2
     * 思路：
     * 1.每次往新链表插入时，都要比较head1和head2当前节点的数据哪个更小，把小的插入到新链表nowNode中0（比如，nowNode.next = ），
     * 2.
     * 3.如果head1和head2中的任何一个链表的下一个节点为空时，把不为空的链表的所有数据插入到新链表中，插入完成。
     * */
    private ListNode mergeListNode(ListNode head1, ListNode head2) {

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        //从头部开始创建新链表。新链表指针为节点
        ListNode nowNode = null;  //新链表的指针
        ListNode newHead = null;  //用于保存新链表的头部
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

        //此时，head1或者head2已经添加到新链表中，只需要把剩下的一个链表的全部数据添加到新链表后面
        if(head1 == null){
            nowNode.nextNode = head2;
        }else{
            nowNode.nextNode = head1;
        }

        return newHead;
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
