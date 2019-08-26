import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ZOE
 * @date 2019/8/26 20:44
 */

//利用  LinkedHashMap  实现
//利用jdk的LinkedHashMap，覆写其中的removeEldestEntry(Map.Entry)方法即可

public class LRU<K,V> {
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    LinkedHashMap<K, V> map;

    public LRU(int max_cache_size) {
        MAX_CACHE_SIZE = max_cache_size;
        int capacity = (int)Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1;
        /*
         * 第三个参数设置为true，代表linkedlist按访问顺序排序，可作为LRU缓存
         * 第三个参数设置为false，代表按插入顺序排序，可作为FIFO缓存
         */
        map=new LinkedHashMap<K,V>(capacity,DEFAULT_LOAD_FACTORY,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size()> MAX_CACHE_SIZE;
            }
        };
    }
    public synchronized void put(K key,V value){
        map.put(key,value);
    }
    public synchronized V get(K key){
        return map.get(key);
    }
    public synchronized void remove(K key){
        map.remove(key);
    }
    public synchronized Set<Map.Entry<K,V>> getAll(){
        return map.entrySet();
    }
    @Override
    public String toString(){
       StringBuilder stringBuilder=new StringBuilder();
        for (Map.Entry<K,V> entry:map.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ",entry.getKey(),entry.getValue()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRU<Integer,Integer> lru=new LRU<>(5);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru);
        lru.get(1);
        System.out.println(lru);
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6); //元素超了，删除最早的元素
        System.out.println(lru);
    }
}
