package test;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
//HashMap ��һ��ɢ�б����洢�������Ǽ�ֵ��(key-value)ӳ�䡣
//HashMap ��ʵ�ֲ���ͬ���ģ�����ζ���������̰߳�ȫ�ġ�����key��value������Ϊnull�����⣬HashMap�е�ӳ�䲻������ġ�
public class hashmap {

	public static void main(String[] args) {
		HashMap<Integer,Integer > hashMap=new HashMap<Integer, Integer>();
		hashMap.put(1, 3);//put() �������Ƕ����ṩ�ӿڣ���HashMap�������ͨ��put()����key-value����ӵ�HashMap�С�
		hashMap.put(2, 4);
		hashMap.put(3, 5);
		hashMap.put(4, 55);
		hashMap.put(5, 43);
		hashMap.put(6, 23);
		
		//����HashMap��put��key��֮ǰ�Ѿ�������򲻻��ظ��洢���Ḳ��֮ǰkey��Ӧ��value
		hashMap.put(5, 43);
		hashMap.put(6, 23);
		System.out.println("�ж�HashMap�Ƿ����key: "+hashMap.containsKey(6));
//		����hashmap
//		1. ���õ���������Entry��ȡ������ȡ��ֵ���Ƽ�ʹ�����ַ�ʽ���б�����Ч�ʽϸ�
		System.out.println("����haspmap.entrySet().iterator()");
		Iterator<HashMap.Entry<Integer,Integer>> iterator=hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			HashMap.Entry<Integer,Integer> entry=iterator.next();
			Integer keyInteger=entry.getKey();
			Integer vaInteger=entry.getValue();
			System.out.print(keyInteger + "--->" + vaInteger);
			System.out.println();
		}
//		2. ����hashmap.keySet().iterator()�����ü��ĵ�������ÿ��ȡ��һ�������ٸ��ݼ�����hashmap��ȡ��ֵ�����ַ�ʽ��Ч�ʲ��ߣ����Ƽ�ʹ��
		System.out.println("����hashmap.keySet().iterator()");
		Iterator<Integer> iterator2=hashMap.keySet().iterator();
		while (iterator2.hasNext()) {
			Integer key = iterator2.next();
			Integer value=hashMap.get(key);
			System.out.print(key + "--->" + value);
			System.out.println();
			
		}
			
		
		

	}

}
