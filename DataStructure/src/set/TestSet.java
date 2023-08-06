package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @description: 测试类
 * @author: 22783
 * @date: 2023/7/28
 **/
public class TestSet {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("刘亦菲");
        hashSet.add("裴珠泫");
        hashSet.add("林允儿");

        System.out.println("hashSet = " + hashSet);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        hashSet.add("林允儿");
        hashSet.add(null);

        System.out.println("hashSet = " + hashSet);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ArrayList<String> list = new ArrayList<>();
        list.add(null);

        System.out.println("list = " + list);


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println("next = " + next);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        /*熟悉用法*/

        Student student1 = new Student("jiejie", 18);
        Student student2 = new Student("jiejie", 18);
        Student student3 = new Student("jiejie", 18);


        System.out.println("hashCode = " + student1.hashCode());
        System.out.println("hashCode = " + student2.hashCode());
        System.out.println("hashCode = " + student3.hashCode());


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        HashSet<Student> students = new HashSet<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("students = " + students);


       /* List<Student> arrayList = new ArrayList<>();

        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);


        boolean addAll = hashSet.addAll(arrayList);

        System.out.println("addAll = " + addAll);*/

    }
}
