package io;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/2
 **/
public class FileWandR {

    public static void main(String[] args) {


        /*char[] chars = new char[10];


        try (FileWriter writer = new FileWriter(new File("D://test//jiejie.txt"))) {
            writer.write(" 这里是卢本伟广场!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileReader fileReader = new FileReader("D://test//jiejie.txt")) {
            int read = fileReader.read();
            System.out.println("read = " + read);
            fileReader.read(chars, 0, chars.length);
            System.out.println("chars = " + Arrays.toString(chars));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

       /* try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://test//jiejie.txt"))) {
            bufferedWriter.write("伞兵一号卢本伟就位!  盖亚!!!!!!!  肉蛋葱鸡，我将不再低调!");

            bufferedWriter.newLine();
            bufferedWriter.write("伞兵一号卢本伟就位!  盖亚!!!!!!!  肉蛋葱鸡，我将不再低调!");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D://test//jiejie.txt"))) {
            while (bufferedReader.readLine() != null) {
                System.out.println("line = " + bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
