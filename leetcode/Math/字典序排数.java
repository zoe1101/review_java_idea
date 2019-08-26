package Math;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数 n, 返回从 1 到 n 的字典顺序。

例如，

给定 n=13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。

请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。

 */
public class 字典序排数 {
	List<Integer> res=new ArrayList<Integer>();
    public List<Integer> lexicalOrder(int n) {
        if (n<10) {
			for (int i = 1; i <= n; i++) {
				res.add(i);
			}
			return res;
		}
        process(1,n);
        return res;
    }
	private void process(int start, int end) {
		if (start>end) {
			return ;
		}
		for (int i = 0; i < 10 && start + i <= end; ++i) {
	        if (start == 1 && i == 9) break;
	        res.add(start + i);
	        process((start + i) * 10, end);
	    }
	}
}
