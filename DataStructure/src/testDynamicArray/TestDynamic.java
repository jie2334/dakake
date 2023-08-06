package testDynamicArray;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/27
 **/
public class TestDynamic {

    public static void main(String[] args) {
        //测试类
        DynamicArray array = new DynamicArray();

        for (int i = 0; i < 100; i++) {
            array.addElement("裴珠泫");
            System.out.println("array[index] = " + array.getIndex(i).toString());
        }

/*

        Object index = array.getIndex(4);
        //System.out.println("array = " + array.getLength());
        System.out.println("index = " + index.toString());
*/

        /*for (int index = 0; index < array.getSize(); index++) {
            System.out.println("array[index] = " + array.getIndex(index).toString());
        }

        Object removed = array.remove(10);
        System.out.println("removed = " + removed);

        System.out.println(array.getSize());

*/
        DynamicArray array1 = new DynamicArray();

        Student stu1 = new Student("jiejie", 23);
        Student stu2 = new Student("jiejie", 23);
        Student stu3 = new Student("jiejie", 23);
        Student stu4 = new Student("jiejie", 23);

        array1.addElement(stu1);
        array1.addElement(stu2);
        array1.addElement(stu3);
        array1.addElement(stu4);



    }
}
