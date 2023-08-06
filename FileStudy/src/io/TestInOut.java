package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/3
 **/
public class TestInOut {

    public static void main(String[] args) {


        File file = new File("C:\\Users\\22783\\Desktop\\ssm\\peizhuxuan.jpg");

        File newFile = new File("E:\\dakake\\FileStudy\\peizhu.jpg");

        byte[] bytes = new byte[1024];


        try  {
            FileInputStream inputStream = new FileInputStream(file);

            long length = file.length();


            FileOutputStream outputStream = new FileOutputStream(newFile);

            while (inputStream.read(bytes)!=-1){

                long lengthed = newFile.length();
                double l = (double) lengthed % (double) length;
                outputStream.write(bytes);
                System.out.println("l = " + l);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
