package com.jianzhioffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */
public class Answer14 implements AnswerBase {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * */
    public static void main(String [] args){
        Answer14 answer14 = new Answer14();
        answer14.printMain();
    }


    /**
     * 定义answer的入口函数
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

        //输出倒数第4个节点
        ListNode result = findKthToTail(head, 4);//输出倒数第4个节点存储的数
        if(result != null){
            System.out.println("第4个节点存储的数是：" + result.data);
        }else{
            System.out.println("链表不存在或者要查询的节点不存在");
        }

        //输出倒数第5个节点
        result = findKthToTail(head, 5);//输出倒数第5个节点存储的数
        if(result != null){
            System.out.println(result.data);
        }else{
            System.out.println("链表不存在或者要查询的节点不存在");
        }
    }


    /** 输入链表头部节点list，输出该链表中倒数第k个结点。
     * 思路：使用两个遍历链（A和B），让A先走k步，然后B开始走，当A走到链表尾部时A的nextNode为空，此时B即为目标节点，输出B节点的数据
     * 1.pre先走k步，i表示步数
     * 2.如果先走的节点的下一个节点是null，那么aft节点就是目标节点，就跳出循环
     * 3.如果倒数第k个节点不存在，也跳出循环
     * */
    public ListNode findKthToTail(ListNode list,int k){
        if(list == null || k == 0){
            System.out.println("链表不存在或者要查询的节点不存在");
            return null;
        }

        ListNode pre = list;//先走的节点
        ListNode aft = list;//后走的节点
        int i = 0;
        for( ; pre != null; i++){
            pre = pre.nextNode;
            if(i >= k){
                aft = aft.nextNode;
            }
        }

        if(i<k){
            System.out.println("不存在倒数第k个节点");
            return null;
        }
        return aft;
    }


    /**
     * 定义节点
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
