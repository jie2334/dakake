package com.jiejie.dao;

import com.jiejie.Entity.Book;

import java.util.List;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public interface BookDao {
//    增加图书
    boolean addBook(Book book);
//    删除图书
    boolean deleteBook(Book book);
//    获取所有图书
    List<Book> getAllBooks();
//    查询所有图书根据入库时间排序
    List<Book> sortByPublishTime();
//    查看某一本书是否被借阅
    boolean isBorrow(Book book);
}
