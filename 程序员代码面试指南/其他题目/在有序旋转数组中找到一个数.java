package 其他题目;

//二分查找
public class 在有序旋转数组中找到一个数 {
	public static boolean isContains(int[] arr,int num) {
		int low=0;
		int high=arr.length-1;
		while (low<=high) {
			int mid=(low+high)/2;
			if (arr[mid]==num) { //找到了
				return true;
			}
			//左中右相等，num可能在左边，也可能在右边，因此要遍历整个arr[low:high]数组。
			if (arr[low]==arr[mid] && arr[mid]==arr[high]) {
				while (low!=mid && arr[low]==arr[mid]) { //左侧arr[low:mid]遍历
					low++;
				}
				if (low==mid) { //表明num在arr[mid:high]之间
					low=mid+1;
					continue;
				}
			}
			//左中右不都相等
			
			if (arr[low]!=arr[mid]) {//左边不等于中间
				if (arr[mid]>arr[low]) {//左边有序
					if (num>=arr[low]&&num<arr[mid]) { //在左边
						high=mid-1;
					}else { //在右边
						low=mid+1;
					}
					
				}else {//右边有序
					if (num>arr[mid] &&num<=arr[high]) {
						low=mid+1;
					}else {
						high=mid-1;
					}	
				}
			}else {
					if (arr[mid]<arr[high]) {//右边有序
						if (num>arr[mid] &&num<=arr[high]) {
							low=mid+1;
						}else {
							high=mid-1;
						}
					}else {
						if (num>=arr[low] && num<arr[mid]) {
							high=mid-1;
						}else {
							low=mid+1;
						}
					}
			}
		}
		return false;
	}
	public static  void main(String[]args)
    {
        int arr[]={4,5,6,7,1,2,3};
        System.out.println(isContains(arr,5));
    }

}
