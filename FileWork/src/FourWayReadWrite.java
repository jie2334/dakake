import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @description: io -->字符流的读和写   字节流的读和写
 * @author: 22783
 * @date: 2023/8/3
 **/
public class FourWayReadWrite {
    /*读文件*/
    public void testCharRead1(File file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);

            while (fileReader.read() != -1) {
                int read = fileReader.read();
                System.out.println("bytes = " + (char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testCharRead2(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            int data;
            while ((data = reader.read()) != -1) {
                String read = reader.readLine();
                System.out.println("read = " + read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void testCharWrite1(File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            fileWriter.write("jiejie");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void testCharWrite2(File file) {
        BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter(file));

            fileWriter.write("jiejie");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testByteRead1(File file) {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int read;
            while (inputStream.read() != -1) {
                read = inputStream.read(bytes);
                System.out.println("read = " + (char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void testByteRead2(File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath()));

            byte[] bytes = new byte[1024];
            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                int read = bufferedInputStream.read(bytes);
                System.out.println("read = " + read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*写文件*/

    public void testByteWrite1(File file,byte[] arr) {

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);

            outputStream.write(arr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testByteWrite2(File file,byte[] arr) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file.toPath()));

            bufferedOutputStream.write(arr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        File file = new File("E:\\dakake\\FileWork\\src\\test.txt");
        String path ="E:\\dakake\\FileWork\\src\\test.txt";

        byte[] bytes = path.getBytes();

        FourWayReadWrite fourWayReadWrite = new FourWayReadWrite();
        /*字节流*/
        fourWayReadWrite.testByteRead1(file);
        fourWayReadWrite.testByteRead2(file);
        fourWayReadWrite.testByteWrite1(file,bytes);
        fourWayReadWrite.testByteWrite2(file,bytes);


        /*字符流*/

        fourWayReadWrite.testCharRead1(file);
        fourWayReadWrite.testCharRead2(file);

        fourWayReadWrite.testByteRead1(file);
        fourWayReadWrite.testCharRead2(file);

    }
}
