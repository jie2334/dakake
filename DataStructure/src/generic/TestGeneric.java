package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 要注意的是  数组前面的类型不能使用 泛型  ----->   E[length]
 * 要使用Object 关键字，当使用到的时候再进行类型的转换
 * 不能是基本数据类型，只能用引用类型
 *
 * @author: 22783
 * @date: 2023/7/31
 **/
public class TestGeneric {

    /**
     * 使用是先声明再使用
     * @param data
     * @return
     * @param <T>
     */
    public <T> T save(T data){
        return data;
    }
    public static void main(String[] args) {

        Generic<String> stringGeneric = new Generic<>();
        stringGeneric.setElement("jiejie");
        System.out.println("stringGeneric = " + stringGeneric);


        System.out.println("==================================");
        Generic<Integer> integerGeneric = new Generic<>();
        integerGeneric.setElement(101);
        System.out.println("integerGeneric = " + integerGeneric);

        List<Object> list = new ArrayList<>();
        list.add("jiejie");
        list.add(123);

        System.out.println("================== "+list);


        List<Employee> employees = new ArrayList<>();



        employees.add(new Employee("jiejie","12e345677990"));
        employees.add(new Employee("jie","12e34567"));
        employees.add(new Employee("jij","12e377990"));


        for (Employee emp: employees) {
            System.out.println("emp = " + emp.getName()+"address:" +emp.getAddress());
        }

        TestGeneric testGeneric = new TestGeneric();
        testGeneric.save(new Generic<Object>());

    }
}
