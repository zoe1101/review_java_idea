package 其他题目;
/*
实现 LFU 缓存算法, 设计一个类 LFUCache，实现下面三个函数
      构造函数: 传入 Cache 内最多能存储的 key 的数量
   get(key)：如果 Cache 中存在该 key，则返回对应的 value 值，否则，返回-1。 
	若插入后会导致 Cache 中存储的 key 个数超过最大容量，则在插入前淘汰访问次数最少的数据。

注：
所有 key 和 value 都是 int 类型。
访问次数：每次get/set一个存在的key都算作对该key的一次访问；当某个key被淘汰的时候，访问次数清零。
 */

import java.awt.font.TextHitInfo;
import java.util.HashMap;

import test.class_A;

public class LFU缓存结构设计 {
	//利用双向链表与哈希表实现
	
	//节点数据结构
	public class Node{
		public Integer key;
		public Integer value;
		public Integer times;
		public Node last;
		public Node next;
		public  Node(int key,int value,int times) {
			this.key=key;
			this.value=value;
			this.times=times;
		}
	}
	//桶结构
	public class NodeList{
		public Node head;
		public Node tail;
		public NodeList last;
		public NodeList next;
		public NodeList(Node node) {
			head=node;
			tail=node;
		}
		public void addNodeFromHead(Node newHead) {
			newHead.next=head;
			head.last=newHead;
			head=newHead;
		}
		public boolean isEmpty() {
			return head==null;
		}
		public void deleteNode(Node node) {
			if (head==tail) {
				head=null;
				tail=null;
			}else {
				if (node==head) {
					head=node.next;
					head.last=null;
				}else if (node==tail) {
					tail=node.last;
					tail.next=null;
				}else {
					node.last.next=node.next;
					node.next.last=node.last;
				}
			}
			node.last=null;
			node.next=null;
		}
	}
	public class LFUCache{
		private int capacity;
		private int size;
		private HashMap<Integer, Node> records; //key由哪个Node表示
		private HashMap<Node, NodeList> heads; //Node在哪个桶NodeList中
		private NodeList headList; //最左边的桶
		public  LFUCache(int k) {
			this.capacity=k;
			this.size=0;
			this.records=new HashMap<Integer, Node>();
			this.heads=new HashMap<Node, NodeList>();
			headList=null;
		}
		/**
		 * 判断刚才删除了一个节点后的桶是否为空，如果不为空就什么也不做
		 * 如果为空，需要作调整
		 * @param removeNodeList:刚才删除了一个节点后的桶
		 * @return
		 */
		private boolean modifyHeadList(NodeList removeNodeList) {
			if (removeNodeList.isEmpty()) {//如果刚才删除了一个节点后的桶为空
				if (headList==removeNodeList) { //为空且是最左边的桶，则删除最左边的桶
					headList=removeNodeList.next;
					if (headList!=null) {
						headList.last=null;
					}
				}else { //不是最左边的桶
					removeNodeList.last.next=removeNodeList.next; //删除remove的节点
					if (removeNodeList.next!=null) { 
						removeNodeList.last=removeNodeList.last;
					}
				}
				return true;
			}
			return false;
		}
		private void move(Node node,NodeList oldNodeList) {
			oldNodeList.deleteNode(node); //在原始桶中删除节点node
			NodeList preList=modifyHeadList(oldNodeList)?oldNodeList.last:oldNodeList; //得到node应该添加的桶的前一个桶
			NodeList nextList=oldNodeList.next;  //得到node应该添加的桶的后一个桶
			if (nextList==null) { //最后一个桶
				NodeList newList=new NodeList(node);
				if (preList!=null) {
					preList.next=newList;
				}
				newList.last=preList;
				if (headList==null) {
					headList=newList;
				}
				heads.put(node, newList);
			}else {
				if (nextList.head.times.equals(node.times)) { //应该插在桶的头结点位置
					nextList.addNodeFromHead(node);
					heads.put(node, nextList);
				}else {
					NodeList newList=new NodeList(node);
					if (preList!=null) {
						preList.next=newList;
					}
					newList.last=preList;
					newList.next=nextList;
					nextList.last=newList;
					if (headList==nextList) {
						headList=newList;
					}
					heads.put(node, newList);
				}
			}
			
			
		}
		public void set(int key,int value) {
			if (records.containsKey(key)) {
				Node node=records.get(key);
				node.value=value;
				node.times++;
				NodeList curNodeList=heads.get(node);
				move(node, curNodeList);
			}else {
				if (size==capacity) {
					Node node=headList.tail;
					headList.deleteNode(node);
					modifyHeadList(headList);
					records.remove(node.key);
					heads.remove(node);
					size--; //保证后续操作的有效性
				}
				Node node=new Node(key, value, 1);
				if (headList==null) {
					headList=new NodeList(node);
				}else {
					if (headList.head.times.equals(node.times)) {
						headList.addNodeFromHead(node);
					}else {
						NodeList newList=new NodeList(node);
						newList.next=headList;
						headList.last=newList;
						headList=newList;
					}
				}
				records.put(key, node);
				heads.put(node, headList);
				size++;
			}
		}
		public Integer get(int key) {
			if (!records.containsKey(key)) {
				return null;
			}
			Node node=records.get(key);
			node.times++;
			NodeList curNodeList=heads.get(node);
			move(node, curNodeList);
			return node.value;
		}
	}
}
