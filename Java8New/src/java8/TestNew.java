package java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 测试Java8新特性
 * @author: 22783
 * @date: 2023/8/8
 **/
public class TestNew {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("开始进行！");
        });
    }


    @Test
    public void tests(){
        ArrayList<String> list = new ArrayList<>();
        list.add("jiejie");
        list.add("刘亦菲");
        list.add("裴珠泫");
        list.add("");

        Stream<String> stringStream = list.stream().filter(String::isEmpty);


        stringStream.forEach(s -> System.out.println("s = " + s));


    }

    @Test
    public void testLambda(){
        MyInterface myInterface = Integer::sum;

        MyInterface anInterface = (a,b)-> 0;

    }

    @Test
    public void testApply(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.forEach(System.out::println);

        System.out.println("=========================");
        /*获取不能被2整除的*/
        Object[] array = list.stream().filter(i -> i % 2 != 0).toArray();
        /*打印出来*/
        System.out.println("array = " + Arrays.toString(array));


        /*测试map*/
        list.stream().map((Function<Integer, String>) index -> String.valueOf(index * index)).forEach(System.out::println);

        System.out.println("=========================");
        list.stream().limit(3).forEach(System.out::println);

        System.out.println("=========================");
        Integer integer = list.stream().findFirst().get();
        System.out.println("integer = " + integer);
        System.out.println("=========================");
        /*测试sort方法*/
        /*从大到小排列*/
        /*测试集合*/
        List<Integer> collect = list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        System.out.println("collect = " + collect);


    }
}
