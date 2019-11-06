package com.sort;

public class NodeTree {

	public static void main(String [] args){
		int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

		/* 实现 有序二叉树 */
		NodeTree nodeTree = new NodeTree();
		for(int i=0; i<data.length; i++){
			nodeTree.insert(data[i]);
		}
		nodeTree.inOrder();//输出中序遍历结果
		nodeTree.preOrder();//前序遍历
		nodeTree.postOrder();//后序遍历

	}

	private Node root;
	
	public NodeTree() {
		root = null;
	}
	
	//把data插入到二叉树中
	public void insert(int data) {
		if(root==null){
			root = new Node(data);
		}
		else {
			root.add(data);
		}
	}

    //中序遍历打印节点
	public void inOrder(){
	    System.out.print("中序遍历结果：");
	    root.printNode();
    }

	//前序遍历
	public void preOrder() {
	}

	//后序遍历
	public void postOrder() {
	}

	public class Node{
		public int data;
		public Node leftNode;
		public Node rightNode;
		
		public Node(int  data) {
			this.data = data;
			leftNode = null;
			rightNode = null;
			System.out.println("该节点赋值为：" + data);
		}

		//小于父节点则为左，大于父节点则为右
		public void add(int data){
			if(data < this.data){
				if(this.leftNode==null){
					this.leftNode = new Node(data) ;
				}
				else{//左孩子非空
					this.leftNode.add(data);
				}
			}

			else if(this.data <= data){
				if(this.rightNode==null){
					this.rightNode = new Node(data) ;
				}
				else{//右孩子非空
					this.rightNode.add(data);
				}
			}

		}

		//中续遍历   左 根 右
		public void printNode(){
            if(this.leftNode!=null ){
                this.leftNode.printNode();
            }
            System.out.print(this.data + " -> ");
            if(this.rightNode!=null ){
                this.rightNode.printNode();
            }
        }

	}
	
	
}
