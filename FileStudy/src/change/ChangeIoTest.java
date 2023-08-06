package change;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/3
 **/
public class ChangeIoTest {

    public void read(File file) {
        char[] c = new char[10];
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(Files.newInputStream(file.toPath()));
            int read = inputStreamReader.read();
            while (read != -1) {
                read = inputStreamReader.read(c, 0, 10);
                System.out.println("read = " + (char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readCharBuffer(File file) {
        char[] c = new char[10];
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(Files.newInputStream(file.toPath()));
            bufferedReader = new BufferedReader(inputStreamReader);
            String read = bufferedReader.readLine();
            while (read != null) {
                read = bufferedReader.readLine();
                System.out.println("read = " + read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(inputStreamReader).close();
                Objects.requireNonNull(bufferedReader).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bridgeTest(){

    }

    public static void main(String[] args) {
        //new一个字节流
        try {
            FileInputStream fileInputStream = new FileInputStream("D://test//jiejie.txt");
            InputStreamReader streamReader = new InputStreamReader(fileInputStream, "utf-8");
            System.out.println();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            int read = bufferedReader.read();
            System.out.println("read = " + read);

            BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get("C:\\Users\\22783\\Desktop\\ssm\\323539559_673111174516219_7057274385079513525_n.jpg"))));
            String read1 = reader.readLine();
            while (read1 != null) {
                read1 = reader.readLine();
                System.out.println("read1 = " + read1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ChangeIoTest changeIoTest = new ChangeIoTest();
        changeIoTest.readCharBuffer(new File("D://test//jiejie.txt"));
    }
}
