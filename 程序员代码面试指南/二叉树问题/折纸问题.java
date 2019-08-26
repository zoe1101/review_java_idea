package 二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
请把一段纸条竖着放在桌子上， 然后从纸条的下边向上方对折1次， 压出折痕后展开。
 此时 折痕是凹下去的， 即折痕突起的方向指向纸条的背面。 如果从纸条的下边向上方连续对折2次，
  压出折痕后展开， 此时有三条折痕， 从上到下依次是下折痕、 下折痕和上折痕。

给定一 个输入参数n， 代表纸条都从下边向上方连续对折n次，请从上到下打印所有折痕的方向。 
例如： n=1时， 打印： down
n=2时， 打印： down down up

若为下折痕则对应元素为"down",若为上折痕则为"up".


折纸n次产生 2^n -1个折痕，符合如下的完全二叉树

		down
	   /    \
	down     up
	/ \     /  \
 down up  down  up

 * @author zoe
 *
 */
public class 折纸问题 {
	List<String> list = new ArrayList<>();
	public String[] foldPaper(int n) {
		inOrder(n, true);
        String[] res = list.toArray(new String[]{});
        return res;
    }
	
	public void inOrder(int n, boolean isDown){
		if(n == 0){
            return;
        }
        inOrder(n - 1, true); //左子树
        //根节点
        if(isDown) {
            list.add("down");
        }else {
            list.add("up");
        }
        inOrder(n - 1, false); //右子树
	}    
}
