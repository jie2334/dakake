package recursion;

/**
 * @description: 文件递归
 * @author: 22783
 * @date: 2023/8/1
 **/
public class TestRecursion {

    public int function(int n){
        if (n==0||n==1)
            return n;
        else {
            return function(n-1)+function(n-2);
        }
    }

    public static void main(String[] args) {

        TestRecursion recursion = new TestRecursion();
        int function = recursion.function(10);
        System.out.println("function = " + function);
    }
}
