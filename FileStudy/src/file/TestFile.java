package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

/**
 * @description: file测试
 * @author: 22783
 * @date: 2023/8/1
 **/
public class TestFile {


    public static void main(String[] args) throws IOException {
        try{
            /*创建文件*/
            String pathName = "D:\\test\\";

            int prefix = 0;
            File file = new File(pathName);
            //先判断是否存在   存在-删除  不存在-false
            file.deleteOnExit();
            //创建该文件夹
            file.mkdirs();
            //判断是否存在
            boolean exists = file.exists();
            //获取file的绝对路径
            File absoluteFile = file.getAbsoluteFile();
            //删除文件
            file.delete();
            //判断文件是否有效
            boolean execute = file.canExecute();
            //判断文件是否可以读取
            boolean canRead = file.canRead();
            //判断文件是否可以写入
            boolean canWrite = file.canWrite();
            //比较传入的文件名按照系统的字典顺序
            file.compareTo(new File(pathName));
            //返回是否能创建新文件
            boolean newFile = file.createNewFile();
            //测试此抽象路径名是否与给定对象相等。
            file.equals(new Object());
            //返回文件的规范形式
            File canonicalFile = file.getCanonicalFile();
            //返回file的未被占用的字节数
            long freeSpace = file.getFreeSpace();
            //获取父级文件对象的字符串
            String parent = file.getParent();
            //返回父级文件对象
            File parentFile = file.getParentFile();
            //返回此对象被分配的大小
            long totalSpace = file.getTotalSpace();
            //返回被占用的大小
            long usableSpace = file.getUsableSpace();
            //判断是不是文件夹
            file.isDirectory();
            //判断是不是绝对路径
            boolean absolute = file.isAbsolute();
            //返回文件最后一次修改的时间
            long l = file.lastModified();
            //文件移动到
            //boolean b = file.renameTo();
            //赋予权限
            file.setExecutable(false);
            //获取子级的所有对象列表
            File[] files = file.listFiles();

            //转成path对象
            Path path = file.toPath();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
