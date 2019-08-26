package src;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * 
 * 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 * @author zoe
 *
 */
public class 复杂链表的复制 {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	/**
 * 第一步仍然是复制原始链表上的每个结点N创建N'，然后把这些创建出来的结点用m_pNext链接起来。同时我们把<N, N'>的配对信息放到一个哈希表中。
 * 第二步还是设置复制链表上的每个结点的m_pSibling。如果在原始链表中结点N的m_pSibling指向结点S，那么在复制链表中，对应的N'应该指向S'。
 * 由于有了哈希表，我们可以在O(1)的时间根据S找到S’。这种是以O(n)的空间换来了O（n）的时间复杂度。

	 * @param pHead
	 * @return
	 */
    public RandomListNode Clone(RandomListNode pHead){
    	if(pHead==null) {
    		return null;
    	}
    	HashMap<RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode pClonedHead =new RandomListNode(pHead.label);//复制链表的头结点
    	RandomListNode pNode=pHead,pClonedNode =pClonedHead;
    	map.put(pNode, pClonedNode);
    	//第一步，hashMap保存，原链表节点映射复制链表节点
    	while (pNode.next!=null) {
			pClonedNode.next=new RandomListNode(pNode.next.label);
			pNode=pNode.next;
			pClonedNode=pClonedNode.next;
			map.put(pNode, pClonedNode);
		}
    	
    	//第二步：找到对应的特殊指针
    	pNode=pHead;
    	pClonedNode=pClonedHead;
    	while (pClonedNode!=null) {
			pClonedNode.random=map.get(pNode.random);
			pNode=pNode.next;
			pClonedNode=pClonedNode.next;
		}		
    	
        return pClonedHead;
    }
    /**
     * 优化方法
     * 第一步：让仍然是根据原始链表的每个结点N创建对应的N'。不过我们把N’链接在N的后面。
     * 第二步：设置复制出来的结点的m_pSibling。原始链表上的A的m_pSibling指向结点C，
     * 那么其对应复制出来的A’是A的m_pNext指向的结点，同样C’也是C的m_pNext指向的结点。
     * 即A' = A.next，A'.m_pSibling = A.m_pSibling.next；
     * 故像这样就可以把每个结点的m_pSibling设置完毕。
     * 第三步：将这个长链表拆分成两个链表：把奇数位置的结点用m_pNext链接起来就是原始链表，
     * 把偶数位置的结点用m_pNext链接起来就是复制出来的链表。

     * @param pHead
     * @return
     */
    public RandomListNode Clone2(RandomListNode pHead){
    	RandomListNode pNode=pHead;
    	while (pNode!=null) {
    		//创建pClonedNode结点即A'结点使其指向原始链表中A结点的下一结点B,不过A'的m_pSibling设置为null
			RandomListNode pClonedNode=new RandomListNode(pNode.label);
			pClonedNode.next=pNode.next;
			pClonedNode.random=null;
			//将A结点指向A’结点
			pNode.next=pClonedNode;
			//使pNode指向A的下一结点B并以此循环修改(此时中间已将克隆结点A‘插入了原始列表)
			pNode=pClonedNode.next;
			
		}
    	

    	//设置每个结点的m_pSibling(注：m_pSibling为空结点不做修改)
    	pNode=pHead;
    	while (pNode!=null) {
			RandomListNode pClonedNode=pNode.next;
			if(pNode.random!=null) {
				pClonedNode.random=pNode.random.next;
			}
			pNode=pClonedNode.next;
		}
    	

    	//拆分链表
    	pNode=pHead;
    	RandomListNode pClonedHead =null;
    	RandomListNode pClonednNode =null;
    	if(pNode!=null) {
    		pClonedHead=pClonednNode=pNode.next;
    		pNode.next=pClonednNode.next;
    		pNode=pNode.next;
    	}
    	while (pNode!=null) {
    		pClonednNode.next=pNode.next;
    		pClonednNode=pClonednNode.next;
    		pNode.next=pClonednNode.next;
    		pNode=pNode.next;
			
		}
    	return pClonedHead;

    }
}
