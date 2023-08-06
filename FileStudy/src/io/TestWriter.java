package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/2
 **/
public class TestWriter {


    public static void main(String[] args) {


        String path = "D://test//jiejie.txt";

        byte[] bte = {'1','2','3','4',' ','8','9'};

        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            outputStream.write(bte);
            outputStream.write(43);
            outputStream.write(bte,2, bte.length-2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
