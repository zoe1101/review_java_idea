package 华为20190821;

import java.util.*;

/**
 * 给你一个人名(字符串)，和几个群组(包含人名)，每个人都给所在群组的人发消息，问最终多少个人可以收到消息。
 * @author ZOE
 * @date 2019/8/21 19:39
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstPersonName=scanner.next();//发第一条信息的人名
        int m=scanner.nextInt(); //群组个数
        if (m<=0 || m>100){
            System.out.println("m输入有误！");
            return;
        }
        List<List<String>> grouplist=new ArrayList<>(); //群组人员列表
        for (int i = 0; i <m ; i++) {
            grouplist.add(Arrays.asList(scanner.next().split(",")));
        }
        int count=1; //收到消息的人数
        Queue<String> queue=new LinkedList<>();
        queue.offer(firstPersonName);

        HashSet<String> set=new HashSet<>();
        set.add(firstPersonName);
        while (!queue.isEmpty()){//不为空，表明还可以进行消息传播
            String temp=queue.poll();
            for (int i = 0; i <grouplist.size() ; i++) {
                if (grouplist.get(i).contains(temp)){ //第i个群组中包含有temp这个人，那个这个群组的人就都知道了
                    List<String> list=grouplist.get(i);
                    grouplist.remove(i); //移除该群组
                    i--;
                    for (int j = 0; j < list.size(); j++) {
                        if (!set.contains(list.get(j))){
                            queue.offer(list.get(j));
                            set.add(list.get(j));
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
