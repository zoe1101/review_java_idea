package src;

import java.util.Arrays;


/*
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 */

//Step1：排序
//Step2：计算0的个数
//Step3：计算相邻数字的“距离”，并且保证除0外相邻数字不能重复。
//Step4：比较“距离”是否小于0的个数。
public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
    	int zero=0;
    	int dis=0;
    	if(numbers==null || numbers.length!=5) {
    		return false;
    	}
    	//排序
    	Arrays.sort(numbers);
    	// 统计0的个数
    	for (int i = 0; i < numbers.length-1; i++) {
			if(numbers[i]==0) {
				zero++;
				continue;
			}
			if(numbers[i]==numbers[i+1]) {
				return false;
			}
			if(numbers[i+1]-numbers[i]>1) {
				dis+=numbers[i+1]-numbers[i]-1;
			}
		}
    	return zero>=dis?true:false;

    }
}
