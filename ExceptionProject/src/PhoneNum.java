/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/24
 **/
public class PhoneNum {


    public boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^1[3456789]\\d{9}$";
        return phoneNumber.matches(regex);
    }

    public static void main(String[] args) {
        String phoneNumber = "13812345678";

        PhoneNum phoneNum = new PhoneNum();
        boolean b = phoneNum.validatePhoneNumber(phoneNumber);

        System.out.println("b = " + b);
    }
}
