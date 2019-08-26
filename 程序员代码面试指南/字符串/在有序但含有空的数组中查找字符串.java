package 字符串;

public class 在有序但含有空的数组中查找字符串 {
	public static int getIndex(String[] strs,String str) {
		if(str==null || strs.length==0 ||strs==null) {
			return -1;
		}
		int res=-1;
		int left=0;
		int right=strs.length-1;
		int i=0;
		while (left<=right) {
			int mid=(right+left)/2;
			if(strs[mid]!=null && strs[mid].equals(str)) {//strs[mid]=str,那么str可能在0-mid范围内
				res=mid;
				right=mid-1;
			}else if(strs[mid]!=null){
				if(strs[mid].compareTo(str)<0) { //strs[mid]小于str，表明str在mid右边
					left=mid+1;
				}else {//表明str在mid左边
					right=mid-1;
				}
			}else {//strs[mid]==null且不等于str，表明str！=null , 此时不确定str在mid的左边还是右边
				i=mid;
				while (strs[i]==null && --i>=left) ;//先找到从mid开始想左边不为null的位置
				if(i<left ||strs[i].compareTo(str)<0) { //左边全是null，且strs[mid]小于str，表明str在mid右边
					left=mid+1;
				}else { //左边不全是null
					res=strs[i].equals(str)?i:res;
					right=i-1;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs= {"a",null,"b",null,null,"c"};
		String str="b";
		System.out.println(getIndex(strs, str));
		
	}
}
