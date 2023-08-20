package com.jiejie.dao.impl;

import com.jiejie.Entity.Book;
import com.jiejie.Entity.Borrow;
import com.jiejie.Entity.User;
import com.jiejie.dao.BorrowDao;
import com.jiejie.utils.DruidUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public class BorrowDaoImpl implements BorrowDao {
    @Override
    public boolean addBorrow(Borrow borrow) {
        String sql = "insert into borrow values(?,?,?,?,?)";

        String updateBook = "update book set is_borrow = ? where book_id = ?";


        boolean execute = false;
        try{

            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, borrow.getBorrow_id());
            prepareStatement.setInt(2, borrow.getUser_id());
            prepareStatement.setInt(3, borrow.getBook_id());
            java.sql.Date date = new java.sql.Date(borrow.getBorrow_date().getTime());
            prepareStatement.setDate(4, date);
            prepareStatement.setNull(5,Types.DATE);

            prepareStatement.addBatch();


            prepareStatement = connection.prepareStatement(updateBook);

            prepareStatement.setBoolean(1,true);
            prepareStatement.setInt(2, borrow.getBook_id());

            prepareStatement.addBatch();
            int[] executeUpdate = prepareStatement.executeBatch();

            connection.commit();
            return executeUpdate.length>0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public boolean addBorrowList(List<Borrow> borrows) {
        String sql = "insert into borrow values(?,?,?,?,?)";

        boolean execute = false;
        try{
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            for (Borrow borrow: borrows){
                prepareStatement.setInt(1, borrow.getBorrow_id());
                prepareStatement.setInt(2, borrow.getUser_id());
                prepareStatement.setInt(3, borrow.getUser_id());
                java.sql.Date date1 = new java.sql.Date(borrow.getBorrow_date().getTime());
                java.sql.Date date2 = new java.sql.Date(borrow.getReturn_date().getTime());
                prepareStatement.setDate(4, date1);
                prepareStatement.setDate(5, date2);

                prepareStatement.addBatch();

            }
            int[] ints = prepareStatement.executeBatch();
            connection.commit();
            execute = true;

            System.out.println("ints = " + Arrays.toString(ints));

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public List<Borrow> selectBorrowByUser(User user) {
        ArrayList<Borrow> borrows = new ArrayList<>();
        String sql = "select * from borrow where user_id = ?";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, user.getId());
            ResultSet resultSet = prepareStatement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                Borrow borrow = new Borrow();
                borrow.setBorrow_id(resultSet.getInt("borrow_id"));
                borrow.setUser_id(resultSet.getInt("user_id"));
                borrow.setBook_id(resultSet.getInt("book_id"));
                borrow.setBorrow_date(resultSet.getDate("borrow_date"));
                borrow.setReturn_date(resultSet.getDate("return_date"));

                borrows.add(borrow);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public List<Borrow> selectBorrowRecord(List<User> users) {
        ArrayList<Borrow> borrows = new ArrayList<>();
        String sql = "select * from borrow where user_id = ?";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            for (User user:users){
                prepareStatement.setInt(1, user.getId());
                ResultSet resultSet = prepareStatement.executeQuery();
                while (resultSet.next()){

                    Borrow borrow = new Borrow();
                    borrow.setBorrow_id(resultSet.getInt("borrow_id"));
                    borrow.setUser_id(resultSet.getInt("user_id"));
                    borrow.setBook_id(resultSet.getInt("book_id"));
                    borrow.setBorrow_date(resultSet.getDate("borrow_date"));
                    borrow.setReturn_date(resultSet.getDate("return_date"));

                    borrows.add(borrow);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }

    //多表联查
    @Override
    public List<Borrow> selectUserUnreturned(User user) {
        ArrayList<Borrow> borrows = new ArrayList<>();

        String sql = "SELECT borrow.borrow_id,borrow.user_id, book.book_id,borrow.borrow_date,borrow.return_date\n" +
                "FROM borrow\n" +
                "JOIN book ON borrow.book_id = book.book_id\n" +
                "where borrow.user_id = ? and book.is_borrow = 1;";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, user.getId());
            ResultSet resultSet = prepareStatement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                Borrow borrow = new Borrow();
                borrow.setBorrow_id(resultSet.getInt("borrow_id"));
                borrow.setUser_id(resultSet.getInt("user_id"));
                borrow.setBook_id(resultSet.getInt("book_id"));
                borrow.setBorrow_date(resultSet.getDate("borrow_date"));
                borrow.setReturn_date(resultSet.getDate("return_date"));
                borrows.add(borrow);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public List<Borrow> selectUsersUnreturned(List<User> users) {
        ArrayList<Borrow> borrows = new ArrayList<>();

        String sql = "SELECT borrow.borrow_id,borrow.user_id, book.book_id,borrow.borrow_date,borrow.return_date\n" +
                "FROM borrow\n" +
                "JOIN book ON borrow.book_id = book.book_id\n" +
                "where borrow.user_id = ? and book.is_borrow = ?;";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            for (User user: users){
                prepareStatement.setInt(1,user.getId());
                prepareStatement.setInt(2,1);
                ResultSet resultSet = prepareStatement.executeQuery();
                connection.commit();
                while (resultSet.next()){
                    int borrowId = resultSet.getInt("borrow_id");
                    int userId = resultSet.getInt("user_id");
                    int bookId = resultSet.getInt("book_id");
                    Date borrowDate = resultSet.getDate("borrow_date");
                    Date returnDate = resultSet.getDate("return_date");
                    Borrow borrow = new Borrow();
                    borrow.setBorrow_id(borrowId);
                    borrow.setUser_id(userId);
                    borrow.setBook_id(bookId);
                    borrow.setBorrow_date(borrowDate);
                    borrow.setReturn_date(returnDate);
                    borrows.add(borrow);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public boolean setReturnedById(int borrow_id) {
        String sql = "UPDATE book, borrow " +
                "SET book.is_borrow = ?, borrow.borrow_date = ? " +
                "WHERE book.book_id = borrow.book_id AND borrow.borrow_id = ?";
        try (PreparedStatement statement = DruidUtils.getDataSource().getConnection().prepareStatement(sql)) {
            // 设置更新的参数
            statement.setInt(1, 0); // 设置book表的is_borrow字段为false
            statement.setNull(2, Types.DATE); // 设置borrow表的borrow_date字段为null
            statement.setInt(3, borrow_id); // 设置要更新的记录的borrow_id

            // 执行更新操作
            int rowsAffected = statement.executeUpdate();

            // 返回更新是否成功的结果
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常情况
            return false;
        }
    }

    @Override
    public List<Borrow> selectUserReturn(User user) {
        List<Borrow> borrowList = new ArrayList<>();

        String sql = "SELECT borrow.borrow_id,borrow.user_id, book.book_id, borrow_date,return_date\n" +
                "FROM borrow\n" +
                "JOIN book ON borrow.book_id = book.book_id\n" +
                "where borrow.user_id = ? and is_borrow = 0;";
        try  {
            PreparedStatement prepareStatement = DruidUtils.getDataSource().getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, user.getId());
            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {
                int borrow_id = rs.getInt("borrow_id");
                int book_id = rs.getInt("book_id");
                Date borrow_date = rs.getDate("borrow_date");
                Date return_date = rs.getDate("return_date");

                //设置借阅的属性

                Borrow borrow = new Borrow(borrow_id, user.getId(), book_id, borrow_date, return_date);
                borrowList.add(borrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowList;
    }

    @Override
    public List<Borrow> selectUsersReturn(List<User> users) {
        ArrayList<Borrow> borrows = new ArrayList<>();

        String sql = "SELECT borrow.borrow_id,borrow.user_id, book.book_id,borrow.borrow_date,borrow.return_date\n" +
                "FROM borrow\n" +
                "JOIN book ON borrow.book_id = book.book_id\n" +
                "where borrow.user_id = ? and book.is_borrow = ?;";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            for (User user: users){
                prepareStatement.setInt(1,user.getId());
                prepareStatement.setInt(2,0);
                ResultSet resultSet = prepareStatement.executeQuery();
                connection.commit();
                while (resultSet.next()){
                    int borrowId = resultSet.getInt("borrow_id");
                    int userId = resultSet.getInt("user_id");
                    int bookId = resultSet.getInt("book_id");
                    Date borrowDate = resultSet.getDate("borrow_date");
                    Date returnDate = resultSet.getDate("return_date");
                    Borrow borrow = new Borrow();
                    borrow.setBorrow_id(borrowId);
                    borrow.setUser_id(userId);
                    borrow.setBook_id(bookId);
                    borrow.setBorrow_date(borrowDate);
                    borrow.setReturn_date(returnDate);
                    borrows.add(borrow);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public Borrow getById(int id) {
        String sql = "select * from borrow where user_id = ?";
        Borrow borrow = new Borrow();
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,id);
            ResultSet resultSet = prepareStatement.executeQuery();
            connection.commit();
            while (resultSet.next()) {

                borrow.setBorrow_id(resultSet.getInt("borrow_id"));
                borrow.setUser_id(resultSet.getInt("user_id"));
                borrow.setBook_id(resultSet.getInt("book_id"));
                borrow.setBorrow_date(resultSet.getDate("borrow_date"));
                borrow.setReturn_date(resultSet.getDate("return_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrow;
    }
}
