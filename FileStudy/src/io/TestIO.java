package io;

import java.io.*;
import java.util.ArrayList;

/**
 * @description: 测试IO流方法
 * @author: 22783
 * @date: 2023/8/1
 **/
public class TestIO {

    public static void main(String[] args) {

        byte[] bte = new byte[1024];

        ArrayList<Byte> bytes = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream("D://test//jiejie.txt")) {

            int byteRead;
            while ((byteRead = fileInputStream.read()) != -1) {
                System.out.println("byteRead = " + byteRead);
                System.out.println("byteRead = " + (char) byteRead);

                int read = fileInputStream.read(bte, 3, byteRead);
                System.out.println("read = " + (char) read);
                System.out.println("===================================");
                bytes.add((byte) byteRead);
                System.out.println("bytes = " + bytes);
            }


           /* for (Byte bt:bytes) {
                if (bt =='/n'){
                    System.out.println(" ");
                }
                else {
                    System.out.println(bt.byteValue());
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
