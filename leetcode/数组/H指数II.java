package 数组;
/*
给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。
编写一个方法，计算出研究者的 h 指数。
h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
至多有h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"

示例:
输入: citations = [0,1,3,5,6]
输出: 3 
解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
     由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 
说明:
如果 h 有多有种可能的值 ，h指数是其中最大的那个。
 */
//二分实现
public class H指数II {
	/*
	我们需要找一个mid，从mid开始到最后的文章数记为paperCnt，这些paper的最低引用数量
	要大于等于paperCnt（hIndex定义），那么我们只看最低的引用数量是否大于paperCnt就行了，
	也就是只看citations[mid]是不是大于等于paperCnt就行了。
	 */
    public int hIndex(int[] citations) {
    	int len=citations.length;
        int left=0;
        int right=len-1;
        int res=0;
  
        while(left<=right){
        	int mid=(left+right)>>1;
        	int paperCnt = len - mid;
        	if (paperCnt <= citations[mid]) {
                res = paperCnt;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }
}
