package 数组;

import java.util.Map;
import java.util.TreeMap;

/*
给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

 */
public class 将数据流变为多个不相交区间 {
	private TreeMap<Integer, int[]> map;  //顺序保存区间
	//Initialize your data structure here. 
    public  将数据流变为多个不相交区间() {
    	map = new TreeMap<>();
    }
    
    public void addNum(int val) {
    	if (map.containsKey(val)) //出现了重复值，不用管
            return;
    	
    	//floorEntry(key):返回与最大键小于或等于给定的键key，或者如果不存在这样的键，null关联的键 - 值映射。
    	Map.Entry<Integer, int[]> leftValInterval = map.floorEntry(val);
        Map.Entry<Integer, int[]> rightValInterval = map.ceilingEntry(val);
        int[] leftInterval = leftValInterval != null ? leftValInterval.getValue() : null;
        int[] rightInterval = rightValInterval != null ? rightValInterval.getValue() : null;
        //该值已经存在区间中
        if (leftInterval != null && leftInterval[0] <= val && leftInterval[1] >= val ||
                rightInterval != null && rightInterval[0] <= val && rightInterval[1] >= val)
            return;
        // merge left & right
        if (leftInterval != null && rightInterval != null && leftInterval[1] == val - 1 && rightInterval[0] == val + 1) {
            // keep left, remove right
            leftInterval[1] = rightInterval[1];
            map.remove(rightValInterval.getKey());
        } else if (leftInterval != null && leftInterval[1] == val - 1)
            leftInterval[1] = val;
        else if (rightInterval != null && rightInterval[0] == val + 1)
            rightInterval[0] = val;
        else
            map.put(val, new int[]{val, val});
    }
    
    public int[][] getIntervals() {
    	return map.values().toArray(new int[map.size()][]);
    }
}
