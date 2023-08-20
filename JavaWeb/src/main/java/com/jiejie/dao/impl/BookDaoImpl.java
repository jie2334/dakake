package com.jiejie.dao.impl;

import com.jiejie.Entity.Book;
import com.jiejie.dao.BookDao;
import com.jiejie.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public class BookDaoImpl implements BookDao {
    @Override
    public boolean addBook(Book book) {
        String sql ="insert into book values(?,?,?,?,?,?,?)";
        Connection connection = null;
        int execute =0;
        try{
            connection = DruidUtils.getDataSource().getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);


            prepareStatement.setInt(1,book.getBook_id());
            prepareStatement.setString(2, book.getBook_name());
            prepareStatement.setString(3,book.getAuthor());
            prepareStatement.setInt(4,book.getBook_number());
            prepareStatement.setString(5,book.getDescription());
            prepareStatement.setBoolean(6,book.getIs_borrow());
            prepareStatement.setBoolean(7,book.getIs_deleted());
            execute = prepareStatement.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return execute>0;
    }

    @Override
    public boolean deleteBook(Book book) {
        String sql ="update book set is_deleted = ? where book_id = ?";
        Connection connection = null;
        int execute = 0;
        try{
            connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);


            prepareStatement.setBoolean(1,true);
            prepareStatement.setInt(2,book.getBook_id());

            execute = prepareStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return execute>0;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "select * from book";
        try{
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            connection.commit();
            while(resultSet.next()){
                Book book = new Book();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setBook_name(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setBook_number(resultSet.getInt("book_number"));
                book.setDescription(resultSet.getString("description"));
                book.setIs_borrow(resultSet.getBoolean("is_borrow"));
                book.setPublish_date(resultSet.getDate("publish_date").toLocalDate());

                book.setIs_deleted(resultSet.getBoolean("is_deleted"));

                books.add(book);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> sortByPublishTime() {
        List<Book> books = new ArrayList<>();
        String sql = "select * from book";
        try{
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            connection.commit();
            while(resultSet.next()){
                Book book = new Book();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setBook_name(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setBook_number(resultSet.getInt("book_number"));
                book.setDescription(resultSet.getString("description"));
                book.setIs_borrow(resultSet.getBoolean("is_borrow"));

                book.setIs_deleted(resultSet.getBoolean("is_deleted"));
                book.setPublish_date(resultSet.getDate("publish_date").toLocalDate());


                books.add(book);
            }
            books.sort(comparing(Book::getPublish_date));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public boolean isBorrow(Book book) {
        boolean isBorrow = false;
        String sql = "select is_borrow from book where book_id = ?";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, book.getBook_id());

            ResultSet resultSet = prepareStatement.executeQuery();
            connection.commit();
            while(resultSet.next()){
                isBorrow = resultSet.getBoolean("is_borrow");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isBorrow;
    }
}
