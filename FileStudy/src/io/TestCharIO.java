package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/3
 **/
public class TestCharIO {
    public static void main(String[] args) {
        File file = new File("E:\\dakake\\FileStudy\\src\\text.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            String encoding = writer.getEncoding();
            System.out.println("encoding = " + encoding);
            writer.write("你好jiejie!");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
