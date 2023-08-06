/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/24
 **/
public class EmailNumTest {


    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    public static void main(String[] args) {

        String name = "13367236633";
        EmailNumTest numTest = new EmailNumTest();

        boolean email = numTest.validateEmail(name);

    }
}
