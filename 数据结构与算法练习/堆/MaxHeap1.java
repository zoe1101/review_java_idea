package 堆;

//简单用java实现一下堆的数据结构

import java.util.ArrayList;

public class MaxHeap1 {
  
  
  ArrayList<Integer> heapList = new ArrayList<>();
  
  /*
   *交换堆中的两个元素 
   */
  private void swap(int srcIndex,int dstIndex)
  {
      int tmp = heapList.get(srcIndex);
      
      heapList.set(srcIndex,heapList.get(dstIndex));
      heapList.set(dstIndex, tmp);
      
  }
  
  /*
   *将指定元素的位置进行上移操作 
   */
  private void HeapUp(int index)
  {
              
      if(index > 1)
      {
          int parent = index / 2;
          int parentVal = heapList.get(parent).intValue();
          int indexVal =  heapList.get(index).intValue();
          
          if(indexVal > parentVal)
          {
              swap(parent,index);
              HeapUp(parent);
          }
          
      }
  }
  
  /*
   *将指定元素的位置进行下移操作 
   */
  private void HeapDown(int index)
  {
      int heapSize = heapList.size(); //这里进行了重复的计算,可以将作为形参传入，或者将该函数，写成非递归形式
      
      if(index > heapSize - 1)
      {//节点不存在
          return;
      }
      
      int child = index * 2; //左孩子节点
      
      if(child > (heapSize - 2))
      {//当前节点为叶子节点，不能进行下移操作，直接返回
       //-2是由于最后一个元素已经是要删除的节点，不在计算范围之内
          return;
      }
      else if(child < heapSize - 2) 
      {//有两个孩子节点
           if((Integer)heapList.get(child) < (Integer)heapList.get(child + 1))
           {
               child++; //右孩子结点值大，作为新的父节点
           }
      }
      
      if(heapList.get(child).intValue() > heapList.get(index).intValue())
      {//孩子节点的值大，进行下移
          swap(child, index);
          HeapDown(child);//继续进行下移操作
      }
      
  }
  
  /*
   *向大顶堆中插入一个元素
   */
  public void HeapInsert(int value)
  {
      int heapSize = heapList.size();
      
      if(heapSize == 0)
      {//第一个元素不为堆中的元素，跳过
          heapList.add(-100);
      }
      
      heapList.add(value);
      heapSize++; //添加新元素后，改变堆的大小
      
      HeapUp(heapSize - 1);
  }
  
  /*
   *从大顶堆中删除一个元素 
   */
  public void HeapDelete(int value)
  {
      int index = 1,heapSize = heapList.size();
      for(; index < heapSize; index++)
      {
          if(heapList.get(index).intValue() == value)
          {
              break;
          }
      }
      
      if (index >= heapSize)
      {//元素不存在
          return;
      }
      
      heapList.set(index, heapList.get(heapSize-1)); //将最后一个叶子节点值赋值到当前节点
      HeapDown(index); 
      
      int parent = index / 2;
      
      if(parent > 0 && ( heapList.get(index).intValue() > (Integer)heapList.get(parent).intValue() ))
      {//如果下移操作后该元素大于父节点还要进行上移
          HeapUp(index);
      }
      
      heapList.remove(heapSize - 1);
  }
  
  /*
   * 打印堆元素
   */
  public void PrintHeap()
  {
      for(int i = 1; i < heapList.size(); i++)
      {
          System.out.print(heapList.get(i) + " ");
      }
      
      System.out.println();
  }
  
  public static void main(String args[])
  {
	  MaxHeap1 bigHeap = new MaxHeap1();
      
      bigHeap.HeapInsert(1);
      bigHeap.HeapInsert(3);
      bigHeap.HeapInsert(4);
      bigHeap.HeapInsert(5);
      bigHeap.HeapInsert(8);
      bigHeap.HeapInsert(2);
      bigHeap.HeapInsert(7);
      bigHeap.HeapInsert(6);
      
      bigHeap.PrintHeap();
      
      bigHeap.HeapDelete(2);
      bigHeap.PrintHeap();
      bigHeap.HeapDelete(8);
      bigHeap.PrintHeap();
  }
}
