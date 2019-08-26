package 栈和队列;

import java.util.Stack;

//不能从最左边直接移动到最右边
//也不能从最右边直接移动到左边
//必须通过中间柱子为桥梁
public class 用栈解决汉罗塔问题 {

	public static enum action{ //操作行为列举
		No,LtoM,MtoL,MtoR,RtoM;
	}
//	非递归，借用栈实现
	public static int hanoi1(int num,String left,String mid,String right) {
		Stack<Integer> ls=new Stack<Integer>();
		Stack<Integer> ms=new Stack<Integer>();
		Stack<Integer> rs=new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		for(int i=num;i>0;i--) {//现将所有元素压入左边的栈
			ls.push(i);
		}
		action[] record= {action.No};
		int step=0;
		while (rs.size()!=num+1) {
			//遵循动作不可当前动作不可与前一动作重复的原则
			step+=stackTostack(record, action.MtoL, action.LtoM,ls,ms, left, mid);
			step+=stackTostack(record, action.LtoM, action.MtoL,ms,ls, mid, left);
			step+=stackTostack(record, action.RtoM, action.MtoR,ms,rs, mid, right);
			step+=stackTostack(record, action.MtoR, action.RtoM,rs,ms, right, mid);
		}
		return step;
	}
	public static int stackTostack(action[] record,action preNoAct,action nowAct,
			Stack<Integer> fStack,Stack<Integer> tStack,String from,String to) {
		//当前动作和前一动作不相同，且源栈需要压入目标栈的元素不能大于目标栈顶元素
		if(record[0]!=preNoAct && fStack.peek()<tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move "+tStack.peek()+" from "+ from+" to "+to);
			record[0]=nowAct;
			return 1;
		}
		return 0;
	}

	//递归法
	public static int hanoi2(int num,String left,String mid,String right) {
		if(num<1) return 0;
		return Process(num,left,mid,right,left,right);
	}
	public static int Process(int num,String left,String mid,String right,String from,String to) {
		if(num==1) { //只有一层的情况
			if(from.equals(mid) || to.equals(mid)) { //一次移动一个位置
				System.out.println("Move 1 from "+from+" to "+to);
				return 1;
			}else {//从左边移到右边或从右边移到左边，借用中间柱子
				System.out.println("Move 1 from "+from+" to "+mid);
				System.out.println("Move 1 from "+mid+" to "+to);
				return 2;
			}
		}
		if(from.equals(mid) || to.equals(mid)) {  //一次移动一个位置
//			从左边到中间、从中间到左边、从右边到中间、从中间到右边
			String another=(from.equals(left) || to.equals(left)?right:left);
			int part1=Process(num-1, left, mid, right, from, another);
			int part2=1;
			System.out.println("Move "+num+" from "+from+" to "+to);
			int part3=Process(num-1, left, mid, right, another, to);
			return part1+part2+part3;
		}else {//从左边移到右边或从右边移到左边，借用中间柱子
			int part1=Process(num-1, left, mid, right, from, to);
			int part2=1;
			System.out.println("Move "+num+" from "+from+" to "+mid);
			int part3=Process(num-1, left, mid, right, to, from);
			int part4=1;
			System.out.println("Move "+num+" from "+mid+" to "+to);
			int part5=Process(num-1, left, mid, right, from, to);
			return part1+part2+part3+part4+part5;
		}
			
		
	}

	public static void main(String[] args) {
		System.out.println("非递归的栈方法");
		hanoi1(2,"A","B","C");
		System.out.println("递归方法");
		hanoi2(2,"A","B","C");

	}

}
