package link;


import java.util.LinkedList;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/27
 **/
public class Test {




    public static void main(String[] args) {
        Student stu1 = new Student("jiejie", 23);
        Student stu2 = new Student("jiejie", 23);
        Student stu3 = new Student("jiejie", 23);
        Student stu4 = new Student("jiejie", 23);


        LinkNode linkNode = new LinkNode();
        linkNode.add(stu1);


        System.out.println(linkNode);
        boolean remove = linkNode.remove(stu1);
        System.out.println("remove = " + remove);

        System.out.println("linkNode = " + linkNode);


        LinkedList<Object> objects = new LinkedList<>();
        objects.add(stu1);

        System.out.println("objects = " + objects);
    }
}
