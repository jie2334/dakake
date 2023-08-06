package generic;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/31
 **/

public class Employee {
    private String name;

    private String address;




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

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
