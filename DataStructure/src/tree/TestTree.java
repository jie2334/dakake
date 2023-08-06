package tree;


import java.util.Comparator;
import java.util.TreeSet;

/**
 * @description: 测试tree类
 * @author: 22783
 * @date: 2023/7/28
 **/
public class TestTree {

    public static void main(String[] args) {


        Student student1 = new Student("jiejie", 18);
        Student student2 = new Student("jiejie", 20);
        Student student3 = new Student("jiejie", 30);


        TreeSet<Student> treeSet = new TreeSet<>();


        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);

        /*真他妈的优雅*/
        TreeSet<Student> studentTreeSet = new TreeSet<>(Comparator.comparing(Student::getName).thenComparingInt(Student::getId));


        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);

        for (Student next : treeSet) {
            System.out.println("next = " + next);
        }

        System.out.println("studentTreeSet = " + studentTreeSet);
    }
}
