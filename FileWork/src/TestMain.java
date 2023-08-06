import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/3
 **/
public class TestMain {


    /*copyIMg*/
    public void copyImg(File file) {
        //读文件
        BufferedInputStream bufferedInputStream = null;
        //写文件
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath()));

            bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("E:\\dakake\\FileWork\\peizhuxuan.jpg")));

            byte[] bytes = new byte[1024];

            while (bufferedInputStream.read(bytes) != -1) {
                bufferedOutputStream.write(bytes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try{
                bufferedOutputStream.close();
                bufferedInputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        TestMain testMain = new TestMain();

        File file = new File("E:\\dakake\\FileWork\\108671044_175827990605202_7713332906397927696_n.jpg");
        testMain.copyImg(file);
    }
}
