package collection;

import testDynamicArray.DynamicArray;

/**
 * @description: 测试类
 * @author: 22783
 * @date: 2023/7/28
 **/
public class TestStu {

    public static void main(String[] args) {
        Student student1 = new Student("jiejie", 1);
        Student student2 = new Student("jiejie", 2);
        Student student3 = new Student("jiejie", 3);


        DynamicArray list = new DynamicArray();

        list.addElement(student1);
        list.addElement(student2);
        list.addElement(student3);


        boolean equals = student1.equals(student2);
        System.out.println("equals = " + equals);
        Student liuyifei = new Student("刘亦菲", 3);

        list.addElement(liuyifei);

        System.out.println("list = " + list);
    }
}
