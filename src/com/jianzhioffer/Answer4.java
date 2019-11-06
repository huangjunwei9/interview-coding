package com.jianzhioffer;

import java.util.Scanner;

import static java.lang.System.exit;

public class Answer4 implements AnswerBase{
    /**
     * 题目4：
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * */
    public static void main(String [] args){
        Answer4 answer4 = new Answer4();
        answer4.printMain();

        System.out.println("开始输入第一个数组：");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int i = scanner.nextInt();
            System.out.println(i);
        }

        System.out.println("开始输入第二个数组：");
        while(scanner.hasNext()){
            scanner.nextInt();
        }

    }

    /**
     * 给出前序和中序数据，重构二叉树，采用后序输出
     */
    @Override
    public void printMain() {
        BinaryTree binaryTree = new BinaryTree();
        //1,2,4,8,9,5,10,3,6,7
        //8,4,9,2,10,5,1,6,3,7
        int [] preOrder = {1,2,4,8,9,5,10,3,6,7};
        int [] inOrder = {8,4,9,2,10,5,1,6,3,7};
        binaryTree.initTree(preOrder,inOrder);
        System.out.println("后序遍历输出二叉树：");
        binaryTree.postOrder();
    }



    /**
     * 定义类：节点
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
     * 定义类：二叉树
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
         * 给出前序和中序遍历，重构二叉树
         * 步骤1.找出前序的第一个值，该值应该二叉树的根节点的值
         * 步骤2.在中序中找出该值处于第i个，此时，（start2，i-1）为左孩子集，（i，ends）为右孩子集。
         * 步骤3.然后需要在左孩子集里找出左孩子集的根节点，方法如下：
         *       将前序中的（start1+1，start1+(i-start2)）作为左孩子的前序，将中序中的（start2，i-1）作为左孩子的中序，再次调用initTree函数找出左孩子集中的根节点，
         *       直到 start1+1 > start1+(i-start2) 或者 start2 > i-1，返回null，表示该方向子树为空。
         * 步骤4.然后需要在右孩子集里找出右孩子集的根节点，方法如下：
         *       将前序中的（start1+(i-start2)+1，end1）作为右孩子的前序，将中序中的（i+1，end2）作为右孩子的中序，再次调用initTree函数找出右孩子集中的根节点
         * 步骤5.将左孩子集的根节点 赋值给根节点的左孩子，右孩子集的根节点 赋值给根节点的右孩子，返回head
         * */
        private Node initTree(int [] preOrder, int start1, int end1, int [] inOrder, int start2, int end2){
            if(start1 > end1 || start2 > end2){//表示该方向的子树为空
                return null;
            }

            //找出前序的第一个值，即是二叉树根节点上的值
            int rootData = preOrder[start1];
            Node head = new Node(rootData);

            //在中序中找出rootData处于第i个，此时，（start2，i-1）为左孩子集，（i，ends）为右孩子集。
            int whereRoot = findWhereRoot(rootData, inOrder, start2, end2);
            if(whereRoot == -1){
                System.out.println("中序中没有数值whereRoot");
                System.exit(1);//非正常退出程序
            }

            //在左孩子集里找出左孩子集的根节点，方法如下：
            //将前序中的（start1+1，start1+(i-start2)）作为左孩子的前序，将中序中的（start2，i-1）作为左孩子的中序，再次调用initTree函数找出左孩子集中的根节点，
            Node leftRoot = initTree(preOrder, start1+1, start1+(whereRoot-start2), inOrder, start2, whereRoot-1);

            //在右孩子集里找出右孩子集的根节点，方法如下：
            //将前序中的（start1+(i-start2)+1，end1）作为右孩子的前序，将中序中的（i+1，end2）作为右孩子的中序，再次调用initTree函数找出右孩子集中的根节点
            Node rightRoot = initTree(preOrder,start1+(whereRoot-start2)+1, end1, inOrder, whereRoot+1, end2);

            //将左孩子集的根节点 赋值给根节点的左孩子，右孩子集的根节点 赋值给根节点的右孩子，返回head
            head.left = leftRoot;
            head.right = rightRoot;

            return head;
        }

        //在中序中找出rootData处于第i个，此时，（start2，i-1）为左孩子集，（i，ends）为右孩子集。
        private int findWhereRoot(int rootData, int[] inOrder, int start2, int end2) {
            for(int i = start2; i<=end2; i++){
                if(inOrder[i] == rootData){
                    return i;
                }
            }
            return -1; //表示在中序中没找到该值。
        }

        //供外部掉用二叉树的后序遍历
        public void postOrder() {
            postOrder(this.root);
        }

        //后序遍历（左、右、根）输出，
        private void postOrder(Node node){
            if(node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data + ", ");
            }
        }



    }




}
