package 排序算法;

public class 计数排序 {
	
	public static void countSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		int max=arr[0];
		int min=arr[0];
		//找到序列中的最大值与最小值
		for (int i = 1; i < arr.length; i++) { 
			if (arr[i]<min) {
				min=arr[i];
			}
			if (arr[i]>max) {
				max=arr[i];
			}
		}
		
		int[] help=new int[max-min+1]; //记录 A 中某元素出现的次数
		for (int i = 0; i < arr.length; i++) {
			help[arr[i]-min]++;
		}
		int index=0;
		for (int i = 0; i < max-min+1; i++) {
			while (help[i]>0) {
				arr[index]=min+i;
				index++;
				help[i]--;
			}
		}
	}
	
	
	
	/**
	 * 所有元素都在0-k以内
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] countSort(int[] arr,int k) {
		int[] C=new int[k+1];//构造C数组，统计[0,k]中每个元素出现的次数
		int length=arr.length; //获取A数组大小用于构造B数组  
		int sum=0;
        int[] B=new int[length];//构造B数组,存储最终排序结果
        
        for(int i=0;i<length;i++)
        {
            C[arr[i]]+=1;// 统计A中各元素个数，存入C数组
        }
        
        for(int i=0;i<k+1;i++)//修改C数组
        {
            sum+=C[i];
            C[i]=sum;   //C[i]:记录[0,i]范围内元素的个数
        }
        
        for(int i=length-1;i>=0;i--)//遍历A数组，构造B数组
        {
            B[C[arr[i]]-1]=arr[i];//将A中该元素放到排序后数组B中指定的位置
            C[arr[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素
            
        }
        return B;//将排序好的数组返回，完成排序
        
    }
    public static void main(String[] args)
    {
        int[] A=new int[]{2,5,3,7,2,3,0,3};
        countSort(A);
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }

}
