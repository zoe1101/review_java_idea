package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class 克隆图 {
	// Definition for a Node.
	public static class Node {
	    public int val;
	    public ArrayList<Node> neighbors;

	    public Node() {}

	    public Node(int _val,ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	//深度优先遍历
    public static Node cloneGraph(Node node) {
    	HashMap<Node, Node> hashMap=new HashMap<Node, Node>(); //哈希表用来存储已经访问过的节点
    	return dfs(node, hashMap);
    }
    
    public static Node dfs(Node node, HashMap<Node, Node> map){
    	if (node == null) return null;
    	
    	ArrayList<Node> list = new ArrayList<Node>();
        Node clone_node = new Node(node.val, list);
    	map.put(node, clone_node);
    	
		for(Node neighborNode:node.neighbors) {
			if(!map.containsKey(neighborNode)) { // 如果没有的话就要遍历找到他的neighborNode，再加进去
				Node clone_neighborNode=dfs(neighborNode, map);
				clone_node.neighbors.add(clone_neighborNode);
				
			}else {// 如果map中已经有了这个邻结点信息，直接加进去node的neighborNode
				Node tmp = map.get(neighborNode);
                clone_node.neighbors.add(tmp);
			}
		}
		return clone_node;
    }
    
}
