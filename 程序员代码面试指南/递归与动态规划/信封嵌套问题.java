package 递归与动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**俄罗斯套娃信封
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
不允许旋转信封。
 * @author zoe
 *
 */
public class 信封嵌套问题 {
	public static class Envelope {
		public int len; //信封长
		public int wid; //信封宽
		public Envelope(int length,int widtth) {
			this.len=length;
			this.wid=widtth;
		}
	}
	
	//自定义比较器
	//一个类通过关键字implements声明自己使用一个或者多个接口。
	//Comparator：比较器,  对不同类型的对象进行排序(当然排序依据还是基本类型)
	public static class EnvelopeComparator implements Comparator<Envelope>{
		//改写compare函数
		//长度不等时返回长度的差值,否则返回宽的差值
		public int compare(Envelope o1,Envelope o2) {
			return o1.len!=o2.len?o1.len-o2.len:o2.wid-o1.wid;
		}
	}
/**
 * 先给信封排序，按信封的长度从小到大排，长度相等时，宽度从大到小排序。
 * 问题就简化了成了找宽度数字中的最长递增子序列。
 * @param matrix
 * @return
 */
	public static Envelope[] getSortedEnvelopes(int[][] matrix) {
		Envelope[] res=new Envelope[matrix.length];
		for(int i=0;i<matrix.length;i++) {
			res[i]=new Envelope(matrix[i][0], matrix[i][1]);
		}
		Arrays.sort(res,new EnvelopeComparator()); //实现减序排序,得通过包装类型数组,基本类型数组是不行滴
		return res;
	}
	
	public static int maxEnvelope(int[][] matrix) {
		Envelope[] envelopes=getSortedEnvelopes(matrix); //得到排序的信封
		//利用二分法求最长递增子序列
		int[] ends=new int[matrix.length];
		ends[0]=envelopes[0].wid;
		int right=0;
		int l=0;
		int r=0;
		int m=0;
		for(int i=1;i<envelopes.length;i++) {
			l=0;
			r=right;
			while (l<=r) {
				m=(l+r)/2;
				if(envelopes[i].wid>ends[m]) {
					l=m+1;
				}else {
					r=m-1;
				}
			}
			right=Math.max(right, l);
			ends[l]=envelopes[i].wid;
		}
		return right+1;
	}
	public static void main(String[] args) {
		int[][] matrix= {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelope(matrix));

	}

}
