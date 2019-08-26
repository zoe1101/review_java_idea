package test;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
//HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。
//HashMap 的实现不是同步的，这意味着它不是线程安全的。它的key、value都可以为null。此外，HashMap中的映射不是有序的。
public class hashmap {

	public static void main(String[] args) {
		HashMap<Integer,Integer > hashMap=new HashMap<Integer, Integer>();
		hashMap.put(1, 3);//put() 的作用是对外提供接口，让HashMap对象可以通过put()将“key-value”添加到HashMap中。
		hashMap.put(2, 4);
		hashMap.put(3, 5);
		hashMap.put(4, 55);
		hashMap.put(5, 43);
		hashMap.put(6, 23);
		
		//当在HashMap中put的key在之前已经存过，则不会重复存储，会覆盖之前key对应的value
		hashMap.put(5, 43);
		hashMap.put(6, 23);
		System.out.println("判断HashMap是否包含key: "+hashMap.containsKey(6));
//		遍历hashmap
//		1. 利用迭代器，从Entry中取出键、取出值，推荐使用这种方式进行遍历，效率较高
		System.out.println("利用haspmap.entrySet().iterator()");
		Iterator<HashMap.Entry<Integer,Integer>> iterator=hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			HashMap.Entry<Integer,Integer> entry=iterator.next();
			Integer keyInteger=entry.getKey();
			Integer vaInteger=entry.getValue();
			System.out.print(keyInteger + "--->" + vaInteger);
			System.out.println();
		}
//		2. 利用hashmap.keySet().iterator()：利用键的迭代器，每次取出一个键，再根据键，从hashmap中取出值，这种方式的效率不高，不推荐使用
		System.out.println("利用hashmap.keySet().iterator()");
		Iterator<Integer> iterator2=hashMap.keySet().iterator();
		while (iterator2.hasNext()) {
			Integer key = iterator2.next();
			Integer value=hashMap.get(key);
			System.out.print(key + "--->" + value);
			System.out.println();
			
		}
			
		
		

	}

}
