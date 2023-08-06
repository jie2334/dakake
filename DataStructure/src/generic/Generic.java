package generic;

/**
 * @description: 泛型测试类
 * @author: 22783
 * @date: 2023/7/31
 **/
public class Generic <E>{
    private E element;

    private String name;

    private String address;


    public Generic(E element, String name, String address) {
        this.element = element;
        this.name = name;
        this.address = address;
    }

    public Generic() {

    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "element=" + element +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
