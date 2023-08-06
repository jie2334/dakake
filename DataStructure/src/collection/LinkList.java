package collection;

import java.util.LinkedList;

/**
 * @description: 测试LinkedList API
 * @author: jiejie
 * @date: 2023/7/28
 **/
public class LinkList {


    public static void main(String[] args) {
        /*LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("jiejie");
        String s = linkedList.get(0);
        System.out.println("s = " + s);

        String first = linkedList.getFirst();
        System.out.println("first = " + first);


        String last = linkedList.getLast();
        System.out.println("last = " + last);

        System.out.println("---------------------------------------------------------");

*/
        LinkedList<String> list = new LinkedList<>();
        list.add("lbw");
        list.add("裴珠泫");

        System.out.println("list = " + list);
        String test = "jiejie";
        //添加方法

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals("jiejie")) {
                throw new IllegalArgumentException("有重复元素!");
            }

        }
        list.add(test);


        System.out.println("list = " + list);
    }
}
