package file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Objects;


/**
 * @description: 文件过滤器
 * @author: 22783
 * @date: 2023/8/1
 **/
public class FileFilter {


    public File[] filterFiles(File file,String suffix){
        if (file==null){
            throw new NullPointerException("file为空！");
        }

        File[] files = file.listFiles(pathname -> pathname.getName().endsWith(suffix));
        System.out.println("files = " + Arrays.toString(files));

        return file.listFiles((dir, name) -> name.endsWith(suffix));
    }



    public static void main(String[] args) {

        FileFilter filter = new FileFilter();
        File[] files = filter.filterFiles(new File("D:\\test\\"), ".txt");

        System.out.println("files = " + Arrays.toString(files));


    }
}
