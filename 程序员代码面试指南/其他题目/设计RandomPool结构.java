package 其他题目;

import java.util.HashMap;

public class 设计RandomPool结构 {
	public static class RandomPool<K>{
		private HashMap<K, Integer> keyIndexMap; //记录key到index的对应关系
		private HashMap<Integer,K> indexKeyMap;//记录index到key的对应关系
		private int size; //当前pool的大小
		public RandomPool() {
			this.keyIndexMap=new HashMap<K, Integer>();
			this.indexKeyMap=new HashMap<Integer,K>();
			this.size=0;
		}
		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}
		public void delete(K key) {
			if (this.keyIndexMap.containsKey(key)) {
				int deleteIndex=this.keyIndexMap.get(key); //想要删除的key的index
				int lastIndex=--this.size;
				K lastkey=this.indexKeyMap.get(lastIndex); //pool中最新加入的key
				//把(lastkey，lastIndex)换成(lastkey，deleteIndex) ：把最后一个key的index换成删除key
				this.keyIndexMap.put(lastkey, deleteIndex);
				this.indexKeyMap.put(deleteIndex, lastkey);
				//删除（key,deleteIndex）
				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastIndex);
			}
		}
		public K getRandom() {
			if (this.size==0) {
				return null;
			}
			int randomIndex=(int) Math.random()*this.size;
			return this.indexKeyMap.get(randomIndex);
		}
	}

}
