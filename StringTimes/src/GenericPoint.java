import java.util.Objects;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/31
 **/
public class GenericPoint <E>{
    private E x_point;

    private E y_point;

    public GenericPoint(E x_point, E y_point) {
        this.x_point = x_point;
        this.y_point = y_point;
    }



    public void printPoint(){
        System.out.println("x_point = " + x_point+" y_point = "+y_point);

    }
    public E getX_point() {
        return x_point;
    }

    public void setX_point(E x_point) {
        this.x_point = x_point;
    }

    public E getY_point() {
        return y_point;
    }

    public void setY_point(E y_point) {
        this.y_point = y_point;
    }


}
