package 贪心算法;
/*
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 */


public class 分发糖果 {
    public static int candy(int[] ratings) {
        int[] cd=new int[ratings.length];
        int nums=0;
        if(ratings.length==0) {
        	return 0;
        }
        for(int i=0;i<ratings.length;i++) { //确保每个人都有糖果，初始化为1
        	cd[i]=1;
        }
        for(int i=1;i<ratings.length;i++) {
        	if(ratings[i]>ratings[i-1]) {
        		cd[i]=cd[i-1]+1;
        	}
        }
        for(int i=ratings.length-1;i>0;i--) {
        	if(ratings[i-1]>ratings[i] && cd[i-1]<=cd[i]) {
        		cd[i-1]=cd[i]+1;
        	}
        }
        for(int e:cd) {
        	nums+=e;
        }
        return nums;
    }

	public static void main(String[] args) {
		int[] ratings= {1,0,2};
		System.out.print(candy(ratings));
	}
}
