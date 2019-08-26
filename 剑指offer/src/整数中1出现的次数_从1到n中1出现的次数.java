package src;
/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @author zoe
 *
 */
public class 整数中1出现的次数_从1到n中1出现的次数 {
	//依次遍历每个数,判断每个数里面是否包含1
    public int NumberOf1Between1AndN_Solution(int n) {
        int res=0;
        for(int i=1;i<=n;i++) {
        	res+=number1(i);
        }
        return res;
    }
    public int number1(int n) { //各个数中包含1的个数
		int res=0;
		while (n>0) {
			if(n%10==1) {
				res++;
			}
			n/=10;
		}
		return res;
	}
    
//    将数字转成字符串，直接判断
    public int NumberOf1Between1AndN_Solution2(int n) {
    	int res=0;
    	StringBuffer stringBuffer=new StringBuffer();
        for(int i=1;i<=n;i++) {
        	stringBuffer.append(i);
        }
        String string=stringBuffer.toString();
        for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i)=='1') {
				res++;
			}
		}
        return res;
    }
    
    /**规律法
     *  首先要知道以下规律:
从 1 至 10，在它们的个位数中，任意的 x 都出现了 1 次
从 1 至 100，在它们的十位数中，任意的 x 都出现了 10 次
从1至1000，在它们的百位数中，任意的x都出现了100次
依次类推，从 1 至 10^i，在它们的左数第二位(右数第 i 位)，任意的 x 都出现了 (10^(i-1))次。


对于abXcd来说：
X=0时，如果ab=01，那么就有00100~00199这100个数字都是X位是1的数字
X=1时，如果ab=01，那么就有00100~00199这100个数字 + ab100~ab1cd这个cd个数字
X>=2时，如果ab=01，那么就有00100~00199这100个数字 + 01100~01199这100个数字
     **/
   
    public int NumberOf1Between1AndN_Solution3(int n) {
	    int res = 0;
	    int cur = 0, before = 0, after = 0;
	    int i = 1;
	    while(i<=n){
	        before = n/(i*10);
	        cur = (n/i)%10;
	        after = n - n/i*i;
	        if(cur == 0){
	            // 如果为0. 出现1的次数由高位决定,等于高位数字 * 当前位数
	            res += before * i;
	        }else if(cur == 1){
	            // 如果为1, 出现1的次数由高位和低位决定,高位*当前位+低位+1
	            res += before * i + after + 1;
	        }else{
	            // 如果大于1, 出现1的次数由高位决定,（高位数字+1）* 当前位数
	            res += (before + 1) * i;
	        }
	        i *= 10;
	    }
	    return res;
    }
}
