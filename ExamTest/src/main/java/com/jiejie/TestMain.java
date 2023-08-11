package com.jiejie;

import com.jiejie.entity.TransRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/11
 **/
public class TestMain {
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
            reader.close();
            System.out.println("transRecords = " + transRecords);
        }
        return transRecords;
    }


    public void printDetail(){
        String id = "1044952800";
        try {
            List<TransRecord> records = testRecord();
            TransRecord filterRecord= records.stream().filter(transRecord -> transRecord.getId().equals(id)).findAny().orElse(null);

            System.out.println("筛查之后的记录 = " + filterRecord);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printByPrice(){

        try {
            List<TransRecord> records = testRecord();
            records.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));
            System.out.println("records = " + records);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




    public static void main(String[] args) {
        TestMain main = new TestMain();
        //打印明细记录
        main.printDetail();
        //按升序打印
        main.printByPrice();
    }
}
