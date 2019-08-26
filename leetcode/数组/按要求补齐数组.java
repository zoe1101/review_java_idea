package 数组;
/*
给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，
使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
请输出满足上述要求的最少需要补充的数字个数。

输入: nums = [1,3], n = 6
输出: 1 
解释:
根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
所以我们最少需要添加一个数字。
 */
public class 按要求补齐数组 {
    public int minPatches(int[] nums, int n) {
    	 int len=nums.length;
    	 int ans=0;
    	 long pos=1;  //pos 表示可表示的连续值范围里  的 最大值 +1
    	 for(int i=0;i<len;i++){
    		 if (nums[i]>n) { 
    			 //nums[i] 大过n时，因为无法对1-n 产生作用，且后续元素也大过n，可跳出循环
				break;
			}
    		 //nums数组可表示的连续的值范围： 1-n && n， 中间n-num[i]是没法表示的；
    		 if (nums[i]>pos) { //中间有空隙，所以需要加入元素
				ans++;
				pos=2*pos;
				i--;
			}
    		// nums数组可表示的连续的值范围 可向前延伸 num[i]个长度：即由1-n 变成了 1-n+num[i]。
    		 else {
				pos+=nums[i];
			}
    	 }
    	 while(pos<=n){ //nums数组元素用完，仍无法达到要求时
             pos=2*pos;
             ans++;
         }   
         return ans; 

    }
}
