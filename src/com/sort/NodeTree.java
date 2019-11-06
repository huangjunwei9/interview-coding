package com.sort;

public class NodeTree {

	public static void main(String [] args){
		int [ ] data = {8, 3, 10, 1, 6, 14, 4, 7};

		/* ʵ�� ��������� */
		NodeTree nodeTree = new NodeTree();
		for(int i=0; i<data.length; i++){
			nodeTree.insert(data[i]);
		}
		nodeTree.inOrder();//�������������
		nodeTree.preOrder();//ǰ�����
		nodeTree.postOrder();//�������

	}

	private Node root;
	
	public NodeTree() {
		root = null;
	}
	
	//��data���뵽��������
	public void insert(int data) {
		if(root==null){
			root = new Node(data);
		}
		else {
			root.add(data);
		}
	}

    //���������ӡ�ڵ�
	public void inOrder(){
	    System.out.print("������������");
	    root.printNode();
    }

	//ǰ�����
	public void preOrder() {
	}

	//�������
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
			System.out.println("�ýڵ㸳ֵΪ��" + data);
		}

		//С�ڸ��ڵ���Ϊ�󣬴��ڸ��ڵ���Ϊ��
		public void add(int data){
			if(data < this.data){
				if(this.leftNode==null){
					this.leftNode = new Node(data) ;
				}
				else{//���ӷǿ�
					this.leftNode.add(data);
				}
			}

			else if(this.data <= data){
				if(this.rightNode==null){
					this.rightNode = new Node(data) ;
				}
				else{//�Һ��ӷǿ�
					this.rightNode.add(data);
				}
			}

		}

		//��������   �� �� ��
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
