/**
 * @description: Exception Test Object
 * @author: 22783
 * @date: 2023/7/24
 **/
public class TestException {



    public static void test() throws CustException {
        /**
         * RuntimeException()运行类异常
         *
         *NullPointException
         * IndexOutOfBoundsException
         *
         * 不常用的
         * NoSuchFiledException
         * SecurityException
         *
         */

        /**
         * 继承Exception
         *
         */
        throw new CustException("自定义异常!");
    }



    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            test();
        } catch (CustException e) {
            e.printStackTrace();
        }
        finally {

        }
    }
}
