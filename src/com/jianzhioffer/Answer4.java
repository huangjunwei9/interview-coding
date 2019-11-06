package com.jianzhioffer;

import java.util.Scanner;

import static java.lang.System.exit;

public class Answer4 implements AnswerBase{
    /**
     * ��Ŀ4��
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
     * ���������ǰ���������������Ľ���ж������ظ������֡�
     * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
     * */
    public static void main(String [] args){
        Answer4 answer4 = new Answer4();
        answer4.printMain();

        System.out.println("��ʼ�����һ�����飺");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int i = scanner.nextInt();
            System.out.println(i);
        }

        System.out.println("��ʼ����ڶ������飺");
        while(scanner.hasNext()){
            scanner.nextInt();
        }

    }

    /**
     * ����ǰ����������ݣ��ع������������ú������
     */
    @Override
    public void printMain() {
        BinaryTree binaryTree = new BinaryTree();
        //1,2,4,8,9,5,10,3,6,7
        //8,4,9,2,10,5,1,6,3,7
        int [] preOrder = {1,2,4,8,9,5,10,3,6,7};
        int [] inOrder = {8,4,9,2,10,5,1,6,3,7};
        binaryTree.initTree(preOrder,inOrder);
        System.out.println("������������������");
        binaryTree.postOrder();
    }



    /**
     * �����ࣺ�ڵ�
     */
    class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(){
            left = null;
            right = null;
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    /**
     * �����ࣺ������
     */
    class BinaryTree {

        private Node root;

        public BinaryTree(){
            this.root = null;
        }



        public void initTree(int[] preOrder, int[] inOrder) {
            this.root = initTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
        }


        /*
         * ����ǰ�������������ع�������
         * ����1.�ҳ�ǰ��ĵ�һ��ֵ����ֵӦ�ö������ĸ��ڵ��ֵ
         * ����2.���������ҳ���ֵ���ڵ�i������ʱ����start2��i-1��Ϊ���Ӽ�����i��ends��Ϊ�Һ��Ӽ���
         * ����3.Ȼ����Ҫ�����Ӽ����ҳ����Ӽ��ĸ��ڵ㣬�������£�
         *       ��ǰ���еģ�start1+1��start1+(i-start2)����Ϊ���ӵ�ǰ�򣬽������еģ�start2��i-1����Ϊ���ӵ������ٴε���initTree�����ҳ����Ӽ��еĸ��ڵ㣬
         *       ֱ�� start1+1 > start1+(i-start2) ���� start2 > i-1������null����ʾ�÷�������Ϊ�ա�
         * ����4.Ȼ����Ҫ���Һ��Ӽ����ҳ��Һ��Ӽ��ĸ��ڵ㣬�������£�
         *       ��ǰ���еģ�start1+(i-start2)+1��end1����Ϊ�Һ��ӵ�ǰ�򣬽������еģ�i+1��end2����Ϊ�Һ��ӵ������ٴε���initTree�����ҳ��Һ��Ӽ��еĸ��ڵ�
         * ����5.�����Ӽ��ĸ��ڵ� ��ֵ�����ڵ�����ӣ��Һ��Ӽ��ĸ��ڵ� ��ֵ�����ڵ���Һ��ӣ�����head
         * */
        private Node initTree(int [] preOrder, int start1, int end1, int [] inOrder, int start2, int end2){
            if(start1 > end1 || start2 > end2){//��ʾ�÷��������Ϊ��
                return null;
            }

            //�ҳ�ǰ��ĵ�һ��ֵ�����Ƕ��������ڵ��ϵ�ֵ
            int rootData = preOrder[start1];
            Node head = new Node(rootData);

            //���������ҳ�rootData���ڵ�i������ʱ����start2��i-1��Ϊ���Ӽ�����i��ends��Ϊ�Һ��Ӽ���
            int whereRoot = findWhereRoot(rootData, inOrder, start2, end2);
            if(whereRoot == -1){
                System.out.println("������û����ֵwhereRoot");
                System.exit(1);//�������˳�����
            }

            //�����Ӽ����ҳ����Ӽ��ĸ��ڵ㣬�������£�
            //��ǰ���еģ�start1+1��start1+(i-start2)����Ϊ���ӵ�ǰ�򣬽������еģ�start2��i-1����Ϊ���ӵ������ٴε���initTree�����ҳ����Ӽ��еĸ��ڵ㣬
            Node leftRoot = initTree(preOrder, start1+1, start1+(whereRoot-start2), inOrder, start2, whereRoot-1);

            //���Һ��Ӽ����ҳ��Һ��Ӽ��ĸ��ڵ㣬�������£�
            //��ǰ���еģ�start1+(i-start2)+1��end1����Ϊ�Һ��ӵ�ǰ�򣬽������еģ�i+1��end2����Ϊ�Һ��ӵ������ٴε���initTree�����ҳ��Һ��Ӽ��еĸ��ڵ�
            Node rightRoot = initTree(preOrder,start1+(whereRoot-start2)+1, end1, inOrder, whereRoot+1, end2);

            //�����Ӽ��ĸ��ڵ� ��ֵ�����ڵ�����ӣ��Һ��Ӽ��ĸ��ڵ� ��ֵ�����ڵ���Һ��ӣ�����head
            head.left = leftRoot;
            head.right = rightRoot;

            return head;
        }

        //���������ҳ�rootData���ڵ�i������ʱ����start2��i-1��Ϊ���Ӽ�����i��ends��Ϊ�Һ��Ӽ���
        private int findWhereRoot(int rootData, int[] inOrder, int start2, int end2) {
            for(int i = start2; i<=end2; i++){
                if(inOrder[i] == rootData){
                    return i;
                }
            }
            return -1; //��ʾ��������û�ҵ���ֵ��
        }

        //���ⲿ���ö������ĺ������
        public void postOrder() {
            postOrder(this.root);
        }

        //������������ҡ����������
        private void postOrder(Node node){
            if(node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data + ", ");
            }
        }



    }




}
