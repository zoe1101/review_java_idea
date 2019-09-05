package 并查集;

/**
 * @author ZOE
 * @date 2019/8/31 16:34
 */
public class 朋友圈解法2 {
    public static int findCircleNum(int[][] M) {
        int n=M.length;
        int[] root=new int[n];
        int count=n;
        for (int i=0;i<n;i++){
            root[i]=i;
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (M[i][j]==1){
                    int xf=finRoot(root,i);
                    int yf=finRoot(root,j);
                    if (xf!=yf){
                        root[yf]=xf;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    private static int finRoot(int[] root, int x) {
        while (x!=root[x]){
            x=root[x];
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] M={{1,1,0},{1,1,0}, {0,0,1}};
        System.out.println(findCircleNum(M));
    }

}
