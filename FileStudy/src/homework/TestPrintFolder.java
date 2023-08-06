package homework;

import file.FileFilter;

import java.io.File;
import java.io.FileWriter;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/1
 **/
public class TestPrintFolder {

    //todo 打印该目录下面的所有层级关系
    /*public void testPrint(File file,int level){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null){
                for (File fileSingle: files) {
                    //todo 写入文件里面

                    try{
                        FileWriter writer = new FileWriter();
                        printLevel(level);
                        System.out.println("子文件名: = " + fileSingle.getName());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                    if (fileSingle.isDirectory()) {
                        testPrint(fileSingle,level+1);
                    }
                }
            }
        }
    }

    private void printLevel(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
    }

    public static void main(String[] args) {
        TestPrintFolder printFolder = new TestPrintFolder();

        String pathName = "D://test//";

        File file = new File(pathName);
        printFolder.testPrint(file,0);

    }*/
}
