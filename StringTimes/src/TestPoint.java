/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/31
 **/
public class TestPoint {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GenericPoint<String> point1 = new GenericPoint<String>("2","3");
        GenericPoint<Integer> point2 = new GenericPoint<Integer>(2,3);
        GenericPoint<Double> point3 = new GenericPoint<Double>(2.0,3.0);

        point1.printPoint();
        point2.printPoint();
        point3.printPoint();

    }
}
