package com.library.user;

import com.jiejie.dao.impl.UserDaoImpl;
import com.jiejie.utils.DruidUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public class TestUser {
    @Test
    public void testAddUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        //userDao.addUser();
    }
    @Test
    public void testDelete(){
        UserDaoImpl userDao = new UserDaoImpl();
        //userDao.deleteUser();
    }
    @Test
    public void testEdit(){
        UserDaoImpl userDao = new UserDaoImpl();
        int id = userDao.editUserById(1);
        System.out.println("id = " + id);
    }
}
