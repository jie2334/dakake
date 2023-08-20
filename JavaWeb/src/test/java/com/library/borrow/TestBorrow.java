package com.library.borrow;

import com.jiejie.Entity.Borrow;
import com.jiejie.Entity.User;
import com.jiejie.dao.impl.BorrowDaoImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public class TestBorrow {

    /**
     * 借阅表
     * 1：
     * 2： 增加多条借阅记录
     * 3:
     * 4:
     * 5: 查看某个user的未还记录
     * 6： 查看某几个user的未还记录
     * 7:  把某条借阅记录设置为 已还书
     * 8: 查看某个user的已还书记录
     * 9: 查看多个user的已还书记录
     * 10: 根据某个字段查看借阅数据的信息
     */
//    增加一条借阅记录
    @Test
    public void testAdd(){
        Borrow borrow = new Borrow(7,2,8,new Date(),new Date());
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        boolean b = borrowDao.addBorrow(borrow);
        System.out.println("b = " + b);
    }

//    增加多条借阅记录
    @Test
    public void testAddList(){
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        List<Borrow> borrows = new ArrayList<>();
        Borrow borrow1 = new Borrow(8,2,1,new Date(),new Date());
        Borrow borrow2 = new Borrow(9,3,1,new Date(),new Date());
        Borrow borrow3 = new Borrow(10,3,4,new Date(),new Date());
        Borrow borrow4 = new Borrow(11,4,2,new Date(),new Date());
        Borrow borrow5 = new Borrow(12,4,3,new Date(),new Date());
        borrows.add(borrow1);
        borrows.add(borrow2);
        borrows.add(borrow3);
        borrows.add(borrow4);
        borrows.add(borrow5);
        boolean b = borrowDao.addBorrowList(borrows);

        System.out.println("b = " + b);
    }


//    查看某个user的所有记录
    @Test
    public void selectUserBorrow(){
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        User user = new User(2, "裴珠泫", "女", 18, "南韩第一神颜");
        List<Borrow> borrows = borrowDao.selectBorrowByUser(user);

        System.out.println("borrows = " + borrows);
    }


//    查看几个user的所有记录
    @Test
    public void selectUsersBorrow(){
        ArrayList<User> users = new ArrayList<>();
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        User user1 = new User(2, "裴珠泫", "女", 18, "南韩第一神颜");
        User user2 = new User(1, "刘亦菲", "女", 18, "神仙姐姐");
        User user3 = new User(3, "胡歌", "男", 30, "李逍遥");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<Borrow> borrows = borrowDao.selectBorrowRecord(users);

        System.out.println("borrows = " + borrows);

    }

//    查看某个user的未还记录
    @Test
    public void testUserUnReturn(){
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        User user = new User(2, "裴珠泫", "女", 18, "南韩第一神颜");
        List<Borrow> borrows = borrowDao.selectUserUnreturned(user);
        System.out.println("borrows = " + borrows);
    }

//查看某几个user的未还记录
    @Test
    public void testUsersUnReturn(){
        ArrayList<User> users = new ArrayList<>();
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        User user1 = new User(2, "裴珠泫", "女", 18, "南韩第一神颜");
        User user2 = new User(1, "刘亦菲", "女", 18, "神仙姐姐");
        User user3 = new User(3, "胡歌", "男", 30, "李逍遥");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<Borrow> borrows = borrowDao.selectUsersUnreturned(users);

        System.out.println("borrows = " + borrows);
    }


//把某条借阅记录设置为 已还书
    @Test
    public void testReturn(){
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        boolean b = borrowDao.setReturnedById(1);
        System.out.println("b = " + b);
    }


//查看某个user的已还书记录
    @Test
    public void testUserReturn(){
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        User user = new User(2, "裴珠泫", "女", 18, "南韩第一神颜");
        List<Borrow> borrows = borrowDao.selectUserReturn(user);
        System.out.println("borrows = " + borrows);

    }

//查看多个user的已还书记录

    @Test
    public void testUsersReturn(){
        ArrayList<User> users = new ArrayList<>();
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        User user1 = new User(2, "裴珠泫", "女", 18, "南韩第一神颜");
        User user2 = new User(1, "刘亦菲", "女", 18, "神仙姐姐");
        User user3 = new User(3, "胡歌", "男", 30, "李逍遥");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<Borrow> borrows = borrowDao.selectUsersReturn(users);
        System.out.println("borrows = " + borrows);
    }

//根据某个字段查看借阅数据的信息
    @Test
    public void testBorrowByFiled(){
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        Borrow byId = borrowDao.getById(1);
        System.out.println("byId = " + byId);
    }


}
