package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @description: 测试类
 * @author: 22783
 * @date: 2023/7/28
 **/
public class TestCollect {

    public static void main(String[] args) {
        /*
        *创建ArrayList
        * */
        List<String> arrayList1 = new ArrayList<>();

        List<Object> arrayList2 = new ArrayList<>();

        List<Integer> arrayList3 = new ArrayList<>();


        arrayList1.add("刘亦菲");
        arrayList1.add("刘亦菲");
        arrayList1.add("刘亦菲");
        arrayList1.add("刘亦菲");
        arrayList1.add("刘亦菲");

        arrayList2.add(123);
        arrayList2.add(123);
        arrayList2.add(123);
        arrayList2.add(123);
        arrayList2.add(123);
        arrayList2.add(123);

        System.out.println("arrayList2 = " + arrayList2);

        System.out.println("arrayList1 = " + arrayList1);


        for (int index = 1; index <= 10; index++) {
            arrayList3.add(index);
        }
        //删除
        /*for (int i = 0; i < arrayList3.size(); i++) {
            if (arrayList3.get(i)%2==0){
                arrayList3.remove(i);
            }

        }
*/
        arrayList3.removeIf(next -> next % 2 == 0);
        System.out.println("arrayList3 = " + arrayList3);

        System.out.println("`````````````````````````");

        ListIterator<Integer> listedIterator = arrayList3.listIterator();

        while(listedIterator.hasPrevious()){
            System.out.println("listedIterator = " + listedIterator.previous());
        }
    }
}
