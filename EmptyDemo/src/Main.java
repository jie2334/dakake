import javax.swing.text.BadLocationException;
import java.util.Arrays;


/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/21
 **/
public class Main {
    public static void main(String[] args) throws BadLocationException {

        String name = "D://test//test.txt";
        String[] split = name.split(".txt");
        System.out.println("split = " + Arrays.toString(split));
    }
}
