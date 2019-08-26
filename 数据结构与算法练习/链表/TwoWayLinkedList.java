package 链表;

import test.class_A;
import 链表.SingleLinkedList.Node;

public class TwoWayLinkedList {
	public Node head;//表头节点
	public Node tail;//表尾节点
	public int size; //链表节点个数
	
	public TwoWayLinkedList() {
		size=0;
		head=null;
		tail=null;
	}
	//链表的每个节点类
	public class Node{
		public Object data; //节点元素
		public Node next;//指向下一节点
		public Node prev;//指向上一节点
		public Node(Object data) {
			this.data=data;
		}
	}
	//在链表头增加节点
	public void addHead(Object obj) {
		Node newNode=new Node(obj);
		if(size==0) {//一个元素时，表头等于表尾
			head=newNode;
			tail=newNode;
			size++;
		}else {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			size++;
		}
		
	}
	//在链表尾增加节点
	public void addTail(Object obj) {
		Node newNode=new Node(obj);
		if(size==0) {
			head=newNode;
			tail=newNode;
			size++;
		}else {
			newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
			size++;
		}
	}
	//删除链表头
	public Node deleteHead() {
		Node temp=head;
		if(size!=0) {//非空链表
			head=head.next;
			head.prev=null;
			size--;
		}
		return temp;//返回删除的链表头
	}
	//删除链表尾
	public Node deleteTail() {
		Node temp=tail;
		if(size!=0) {//非空链表
			tail=tail.prev;
			tail.next=null;
			size--;
		}
		return temp;//返回删除的链表尾
	}
	//获得链表的节点个数
	public int getSize() {
		return size;	
	}
	 //判断链表是否为空
	public boolean isEmpty() {
		return (size==0);
	}
	//显示节点信息
	public void display() {
		if(size>0) {
			Node node=head;
			int tempSize=size;
			if(tempSize==1) {//只有一个节点的链表
				System.out.print("["+node.data+"]");
				return;
			}
			while(tempSize>0) {
				if(node.equals(head)) {//头结点
					System.out.print("["+node.data+"->");
				}else if(node.next==null){//尾节点
					System.out.print(node.data+"]");
				}else {//中间结点
					System.out.print(node.data+"->");
				}
				node=node.next;
				tempSize--;
			}
			System.out.println();
		}else {//空链表
			System.out.println("[]");
		}
		
	}
	public static void main(String[] args) {
		TwoWayLinkedList linkedList=new TwoWayLinkedList();
		linkedList.addHead("A");
		linkedList.addHead("B");
		linkedList.addTail("C");
		linkedList.addTail("D");
		linkedList.display();
		linkedList.deleteHead();
		linkedList.deleteTail();
		linkedList.display();

	}

}
