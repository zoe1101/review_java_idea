package 并查集;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，
 * B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 *
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。


 * @author ZOE
 * @date 2019/8/31 15:34
 */

/*
典型的并查集的题，只要两者存在关系，就直接merge到一起，成为一个圈子的人。
最后利用索引，查找有几个boss结点就是几个圈子。
 */
public class 朋友圈 {
    public int findCircleNum(int[][] M) {
        int len=M.length;
        int[] root=new int[len];  //根节点
        for (int i = 0; i <len ; i++) { //根节点赋值初始化为自己
            root[i]=i;
        }

        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len ; j++) {
                if (M[i][j]==1){ //i,j是朋友，i所在的朋友圈与j所在的朋友圈可以进行合并
                    union(root,i,j);
                }
            }
        }

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <len ; i++) {
            set.add(root[i]);
        }
        return set.size();
    }
//合并两个集合
    private void union(int[] root, int x, int y) {
        //查找x，y的根节点
        int xf=find(root,x);
        int yf=find(root,y);
        if (xf==yf){ //根节点相同，属于同一个朋友圈，不用合并
            return;
        }
        //根节点不同，需要进行合并，以x，y根节点的较小值为新集合的根节点，即min。
        int min=Math.min(xf,yf);
        int max=Math.max(xf,yf);
        for (int i = 0; i <root.length ; i++) {
            if (root[i]==max){
                root[i]=min;
            }
        }
    }

    private int find(int[] parent,int x){ //找根节点
        while (parent[x]!=x){
            x=parent[x];
        }
        return x;
    }

}
