package 其他题目;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;



public class 并查集的实现{
	public static class Element<V>{
		public V value;
		public  Element(V val) {
			this.value=val;
		}
	}
	public static class UnionFindSet<V>{
		public HashMap<V, Element<V>> elmentMap;
		public HashMap<Element<V>, Element<V>> fatherMap;
		public HashMap<Element<V>, Integer> rankMap;
		public UnionFindSet(List<V> list) {
			elmentMap=new HashMap<>();
			fatherMap=new HashMap<>();
			rankMap=new HashMap<>();
			for (V v:list) {
				Element<V> element=new Element<V>(v);
				elmentMap.put(v, element);
				fatherMap.put(element, element);
				rankMap.put(element, 1);
			}
			
		}
		private Element<V> findFather(Element<V>  element) {
			Element<V> father = fatherMap.get(element);
			while (element!=fatherMap.get(element)) {
				father = findFather(father);
			}
			fatherMap.put(element, father);
			return father;
		}
		public boolean isSameSet(V a, V b) {
			if (elmentMap.containsKey(a) && elmentMap.containsKey(b)) {
				return findFather(elmentMap.get(a))==findFather(elmentMap.get(b));
			}
			return false;
		}
		public void union(V a, V b) {
			if (elmentMap.containsKey(a) && elmentMap.containsKey(b)) {
				Element<V> aF=findFather(elmentMap.get(a));
				Element<V> bF=findFather(elmentMap.get(b));
				if (aF!=bF) {
					Element<V> big=rankMap.get(aF)>=rankMap.get(bF)?aF:bF;
					Element<V> small=big==aF?bF:aF;
					fatherMap.put(small, big);
					rankMap.put(big, rankMap.get(aF)+rankMap.get(bF));
					rankMap.remove(small);
				}
			}
		}
		
	}

}
