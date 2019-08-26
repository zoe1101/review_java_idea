package 链表;

//单链表的创建、插入、删除、查找、显示
public class SingleLinkedList {
	public int size; //链表节点个数
	public Node head; // 定义一个头结点
	
	public SingleLinkedList() {//构造函数
		size=0;
		head=null;
	}
	//链表的每个节点类
	//使用内部类的最大好处是可以和外部类进行私有操作的互相访问。
	public class Node { 
		public Object data; //每个节点的数据,//数据域
		public Node next; //每个节点指向下一个节点的连接,//指针域
		public Node(Object data) {
			this.data=data;
		}
	}
	//在链表头添加元素
	public Object addHead(Object obj) {
		Node newhead=new Node(obj);
		if(size==0) {
			head=newhead;
		}
		else {//将添加的元素换成表头
			newhead.next=head;
			head=newhead;
		}
		size++;
		return obj;
	}
	//在链表头删除元素
	public Object deleteHead() {
		Object obj=head.data;
		head=head.next;//将下一个元素作为表头
		size--;
		return obj;
	}
	
	//查找指定元素，找到了返回节点Node，找不到返回null
	public Node find(Object obj) {
		Node curNode=head;
		int tempsize=size;
		while(tempsize>0) {
			if(obj.equals(curNode.data)) {
				return curNode; //找到了
			}else {
				curNode=curNode.next;
			}
			tempsize--;
		}
		return null;  //没找到
	}
	
	//删除指定的元素，删除成功返回true
	public boolean delete(Object obj){
		if(size==0) {
			return false;
		}
		Node curNode=head;
		Node preNode=head;
		while(curNode.data!=obj) {
			if(curNode.next==null) { //到链表尾部还未找到对应元素,删除失败
				return false;
			}else {
				preNode=curNode;
				curNode=curNode.next;
			}
		}
		//找到要删除的元素了
		if(curNode==head) {//如果删除的节点是第一个节点
			head=curNode.next;
			size--;
		}else {//删除的节点不是第一个节点
			preNode.next=curNode.next;
			size--;
		}
		return true;
	}
	
	//判断链表是否为空
	public boolean isEmpty() {
		return (size==0);
	}
	
	//显示节点信息
	public void display() {
		if(size>0) {
			Node node=head;
			int tempsize=size;
			if(tempsize==1) {//当前链表只有一个节点
				System.out.print("["+node.data+"]");
				return ;
			}
		while(tempsize>0) {
			if(node.equals(head)) {//头结点
				System.out.print("["+node.data+"->");
			}else if(node.next==null) {//尾节点
				System.out.print(node.data+"]");
			}else {//中间结点
				System.out.print(node.data+"->");
			}
			node=node.next;
			tempsize--;
			}
			System.out.println();
		}else {//空链表
			System.out.println("[]");
			
		}
	}
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList=new SingleLinkedList();
		singleLinkedList.addHead("A");
		singleLinkedList.addHead("B");
		singleLinkedList.addHead("C");
		singleLinkedList.addHead("D");
		singleLinkedList.display();
		singleLinkedList.delete("B");
		singleLinkedList.display();
		System.out.println(singleLinkedList.find("D"));

	}

}
