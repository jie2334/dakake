package com.jiejie.dao;

import com.jiejie.Entity.Borrow;
import com.jiejie.Entity.User;

import java.util.List;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public interface BorrowDao {

    //增加一条借阅记录
    boolean addBorrow(Borrow borrow);

    //增加多条借阅记录
    boolean addBorrowList(List<Borrow> borrows);

    //查看某个user的所有记录
    List<Borrow> selectBorrowByUser(User user);

    //查看几个user的所有记录
    List<Borrow> selectBorrowRecord(List<User> users);
    //查看某个user的未还记录
    List<Borrow> selectUserUnreturned(User user);
    //查看某几个user的未还记录
    List<Borrow> selectUsersUnreturned(List<User> users);
    //把某条借阅记录设置为 已还书
    boolean setReturnedById(int borrow_id);
    //查看某个user的已还书记录
    List<Borrow> selectUserReturn(User user);
    //查看多个user的已还书记录
    List<Borrow> selectUsersReturn(List<User> users);
    //根据某个字段查看借阅数据的信息
    Borrow getById(int id);


}
