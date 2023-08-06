import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description: buffer  VS   file
 * @author: 22783
 * @date: 2023/8/3
 **/
public class TwoTypeVS {
    
    public void testFileInputStream(File file) {

        long start = System.currentTimeMillis();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int read = inputStream.read();
            while (read != -1) {
                read = inputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            long end = System.currentTimeMillis();
            System.out.println("File_time = " + (end - start));
        }
    }

    public void testBufferFileInPutStream(File file) {
        long start = System.currentTimeMillis();
        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(inputStream);
            int read = bufferedInputStream.read();
            while (read != -1) {
                read = bufferedInputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            long end = System.currentTimeMillis();
            System.out.println("Buffer_time = " + (end - start));
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\22783\\Desktop\\ssm\\115712471_916854238790052_1474347859155377669_n.jpg");

        TwoTypeVS twoTypeVS = new TwoTypeVS();

        twoTypeVS.testFileInputStream(file);

        twoTypeVS.testBufferFileInPutStream(file);
    }
}
