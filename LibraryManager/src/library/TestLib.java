package library;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * @description: 测试类
 * @author: 22783
 * @date: 2023/7/26
 **/
public class TestLib {



    /**
     * @param args
     */
    public static void main(String[] args) throws ParseException {




        //初始化bookList
        List<Book> bookList = new ArrayList<>();
        //日期格式化
        DateFormat format = DateFormat.getDateInstance();

        bookList.add(new Book("平凡的世界", "路遥", format.parse("1993-07-21"), false));
        bookList.add(new Book("人生之路", "路遥", format.parse("1997-08-06"), false));
        bookList.add(new Book("活着", "余华", format.parse("1999-06-21"), false));
        bookList.add(new Book("许三观卖血记", "余华", format.parse("1987-05-21"), false));
        bookList.add(new Book("数据结构与算法", "Java大神", format.parse("2002-08-09"), false));
        bookList.add(new Book("C语言基础入门", "谭浩强", format.parse("2003-06-07"), false));
        bookList.add(new Book("Java通关之路", "java之父", format.parse("2012-07-08"), false));
        bookList.add(new Book("那年我双手插兜", "卢本伟", format.parse("2013-03-23"), false));

        //初始化图书馆
        Library library = new Library("小杰图书馆", "软件新城春和路88号", bookList);


        //初始化借阅人
        Reader reader1 = new Reader("胡彦斌", new Date(), new ArrayList<BorrowRecord>(), String.valueOf(UUID.randomUUID()));
        Reader reader2 = new Reader("吴彦祖", new Date(), new ArrayList<BorrowRecord>(), String.valueOf(UUID.randomUUID()));
        Reader jiejie = new Reader("jiejie", new Date(), new ArrayList<BorrowRecord>(), String.valueOf(UUID.randomUUID()));



        HashMap<String, Reader> hashMap = new HashMap<>();
        hashMap.put(reader1.getUuid(), reader1);
        hashMap.put(reader2.getUuid(), reader2);
        hashMap.put(jiejie.getUuid(), jiejie);

        //构造函数传参
        LibrarySystem system = new LibrarySystem(library, hashMap);

        System.out.println("system = " + system);
        //将图书列表按照日期的升序排列

        System.out.println("========================================= ");

        List<Book> books = system.printBookByDate();
        System.out.println("图书馆的books = " + books);
        System.out.println("========================================= ");


        /*调用借书方法*/
        List<BorrowRecord> borrowRecords = system.startBorrow(reader1, "平凡的世界");
        System.out.println("borrowRecords = " + borrowRecords);

        /*调用归还方法*/
        List<BorrowRecord> records = system.returnBook(reader1, "平凡的世界");
        System.out.println("records = " + records);



        /*写入文件*/
        system.saveOnFile(reader1, "D://test//");

        /*读入文件*/
        Map<String, Reader> readerMap = system.readFile(reader1, "D://test//");
        System.out.println("readerMap = " + readerMap);

    }

}
