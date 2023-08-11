package com.jiejie;

import com.jiejie.entity.TransRecord;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @description: 测试类
 * @author: 22783
 * @date: 2023/8/11
 **/
public class TestDemo {

    @Test
    public void returnMinimum(){
        int [] arr = {2,3,1,3,4,5,64,87,7,0,1};
        Arrays.sort(arr);
        System.out.println("arr中最小的数 = " + arr[0]);
    }

    @Test
    public void queryFile(){
        String pathName = "E:\\dakake\\ExamTest\\src\\main\\resources\\";

        File file = new File(pathName);


        String name1 = file.getName();
        System.out.println("name1 = " + name1);

        //判断是不是文件夹，是的话执行下面语句
        if (!file.isDirectory()){
            return;
        }

        File[] files = file.listFiles(pathname -> pathname.getName().endsWith(".avi"));
        assert files != null;
        for(File name : files){
            System.out.println(name.getName());
        }

    }

    @Test
    public void characterString(){
        String str = "fhsalkhfldshssssssssfsjdk";
        char[] charArray = str.toCharArray();

        //统计每一个字母出现的次数，保存到文件中去
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //打印出现的次数
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.println("key: "+characterIntegerEntry.getKey()+" value: "+characterIntegerEntry.getValue());
        }

        //打印出字母次数最多的一对-----说明是键值对

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Optional<Map.Entry<Character, Integer>> max = entries.stream().max(Comparator.comparingInt(Map.Entry::getValue));
        System.out.println("出现次数最多的一个: "+max);

        //保存到文件中
        String pathName = "E:\\dakake\\ExamTest\\src\\main\\resources\\test.txt";
        File file = new File(pathName);
        FileWriter writer = null;
        try  {
            writer = new FileWriter(file);

            for (Map.Entry<Character, Integer> next : entries) {
                writer.write(next.getKey() + ":" + next.getValue() + " ; ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



    @Test
    public void countStrInFile(){
        String pathName = "E:\\dakake\\ExamTest\\src\\main\\resources\\str.txt";

        //读文件
        BufferedReader fileReader;


        try{
            fileReader = new BufferedReader(new FileReader(pathName));

            String line = fileReader.readLine();
            //保存属性
            Map<Character, Integer> hashMap = new HashMap<>();
            for (char c : line.toCharArray()) {
                hashMap.put(c, hashMap.getOrDefault(c,0)+1);
            }


            //打印次数
            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*合并数组*/
    @Test
    public void mergedArray() {

        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8};

        int length1 = arr1.length;

        int length2 = arr2.length;

        int[] ints = Arrays.copyOf(arr1, length1 + length2);

        System.out.println("ints = " + Arrays.toString(ints));


        //遍历数组2，一个个加到inits数组
        for (int i : arr2) {
            ints[length1++] = i;
        }
        System.out.println("ints = " + Arrays.toString(ints));


        Arrays.sort(ints);

        System.out.println("ints = " + Arrays.toString(ints));
    }

    @Test
    public List<TransRecord> testRecord() throws IOException {
        //交易记录集合
        List<TransRecord> transRecords = new ArrayList<>();

        String pathName = "E:\\dakake\\ExamTest\\src\\main\\resources\\TransRecord.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathName));
            while (reader.ready()) {
                //一行行读取
                String line = reader.readLine();
                TransRecord record = new TransRecord();
                //以“ : ”分割
                String[] split = line.split(":");
                record.setId(split[0]);
                record.setPrice(Double.valueOf(split[1]));
                record.setDetail(split[2]);
                System.out.println("record = " + record);
                transRecords.add(record);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            assert reader != null;
            reader.close();
            System.out.println("transRecords = " + transRecords);
        }
        return transRecords;
    }


    @Test
    public void printDetail(){
        String id = "1044952800";
        try {
            List<TransRecord> records = testRecord();
            Stream<TransRecord> stream = records.stream().filter(transRecord -> transRecord.getId().equals(id));

            System.out.println("stream = " + stream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test(){

        //Map map = new Map();
    }


}
