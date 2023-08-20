package com.jiejie.dao;

import com.jiejie.Entity.User;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public interface UserDao {
    boolean addUser(User user);
    boolean deleteUser(User user);
    int editUserById(int id);
}
