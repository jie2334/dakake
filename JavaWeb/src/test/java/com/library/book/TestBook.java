package com.library.book;

import com.jiejie.Entity.Book;
import com.jiejie.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public class TestBook {
    /**
     * 图书表:
     * 1: 增加图书
     * 2: 删除图书
     * 3: 获取所有图书
     * 4: 查询所有图书根据入库时间排序
     * 5: 查看某一本书是否被借阅
     */
    @Test
    public void testAddBook(){
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = new Book(9,"传习录","王阳明",1234568, LocalDate.now(),"把心养的和天一样大",false,false);
        boolean b = bookDao.addBook(book);
        System.out.println("b = " + b);
    }

    @Test
    public void testDelete(){
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = new Book(9,"传习录","王阳明",1234568, LocalDate.now(),"把心养的和天一样大",false,false);
        boolean b = bookDao.deleteBook(book);
        System.out.println("b = " + b);
    }

    @Test
    public void testGetAllBook(){
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> allBooks = bookDao.getAllBooks();
        System.out.println("allBooks = " + allBooks);
    }

    @Test
    public void testSortByTime(){
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> books = bookDao.sortByPublishTime();
        System.out.println("books = " + books);
    }

    @Test
    public void testIsBorrow(){
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = new Book(9,"传习录","王阳明",1234568, LocalDate.now(),"把心养的和天一样大",false,true);
        boolean borrow = bookDao.isBorrow(book);
        System.out.println("borrow = " + borrow);
    }
}
