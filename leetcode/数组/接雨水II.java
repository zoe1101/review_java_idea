package 数组;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，
请计算图中形状最多能接多少体积的雨水。

说明:
m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。

给出如下 3x6 的高度图:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

返回 4。
 */
public class 接雨水II {
	public class Node{
        int x; //x轴坐标
        int y; //y轴坐标
        int h; //高度
        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
	/*
	 每次应该先选取边界最小的高度，可以用优先队列来保存周围边界（小顶堆）。
	 在我们访问过了一个点之后要继续往矩形内部遍历，这样还需要保存一个点的位置．
	为了防止再次访问已经访问过的点还需要用一个数组来标记每个点的访问状态．
	*/
    public int trapRainWater(int[][] heightMap) {
    	if (heightMap.length<3|| heightMap[0].length<3) {
			return 0;
		}
    	PriorityQueue<Node> queue=new PriorityQueue<Node>(new Comparator<Node>() {
    		@Override
    		public int compare(Node o1,Node o2) {
				return o1.h-o2.h;
			}
		});
    	int row=heightMap.length;
    	int col=heightMap[0].length;
    	int[][] visited = new int[row][col];
//    	将这个数组中的边缘元素按照元素大小存入优先级队列中，（x坐标，y坐标，高度）
		 for (int i = 0; i < row; i++) {
			 queue.offer(new Node(i, 0,heightMap[i][0]));
			 visited[i][0]=1;
			 queue.offer(new Node(i, col-1, heightMap[i][col-1]));
			 visited[i][col-1]=1; //将访问过的元素标记
		 }
	   	 for (int j = 1; j < col; j++) {
    		 queue.offer(new Node(0, j,heightMap[0][j]));
    		 visited[0][j]=1;
    		 queue.offer(new Node(row-1, j, heightMap[row-1][j]));
    		 visited[row-1][j]=1;
    	 }
	   	 //方向矩阵
	   	 /*
	   	  {1,0} :向右
	   	  {0,-1}:向下
	   	  {0,1}:向上
	   	  {-1,0}:向左
	   	  */
	   	final int[][] dir = {{1,0},{0,-1},{0,1},{-1,0} };
	   	int res = 0; //积水量
	   	while (!queue.isEmpty()) {
			Node curNode=queue.poll();
			int x=curNode.x;
			int y=curNode.y;
			int h=curNode.h;
			//遍历周围的元素，进行广度搜索
			for (int[] ints:dir) {
				int dx = x + ints[0];
                int dy = y + ints[1];
                if(dx <0 ||dx >= row || dy<0||dy>=col || visited[dx][dy]==1)
                    continue;
                //如果旁边有比这个最低的还低的积木，那么代表当前位置能积水
                if(h> heightMap[dx][dy]){
                    res+=h-heightMap[dx][dy];
                    heightMap[dx][dy] = h ;
                }
              
                queue.add(new Node(dx,dy,heightMap[dx][dy]));//遍历完一个积木 ，将它存入队列中
                visited[dx][dy] =1;//标记
			}
		}
	   	return res;
    }
}
