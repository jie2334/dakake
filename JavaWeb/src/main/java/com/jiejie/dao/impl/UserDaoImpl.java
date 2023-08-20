package com.jiejie.dao.impl;

import com.jiejie.Entity.User;
import com.jiejie.dao.UserDao;
import com.jiejie.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
        String sql ="insert into user values(?,?,?,?,?)";
        Connection connection = null;
        boolean execute =false;
        try{
            connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1,user.getId());
            prepareStatement.setString(2, user.getUsername());
            prepareStatement.setString(3,user.getSex());
            prepareStatement.setInt(4,user.getAge());
            prepareStatement.setString(5,user.getInformation());

            execute = prepareStatement.execute(sql);
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
        return execute;
    }

    @Override
    public boolean deleteUser(User user) {
        String sql = "delete from user where user_id = ?";

        Connection connection = null;
        boolean execute =false;
        try{
            connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,user.getId());
            execute = prepareStatement.execute();
            connection.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public int editUserById(int id) {
        String sql = "update user set username = ? where user_id = ?";

        Connection connection = null;
        int executeUpdate = 0;
        try{
            connection = DruidUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1,"jiejie");
            prepareStatement.setInt(2,id);
            executeUpdate = prepareStatement.executeUpdate();
            connection.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return executeUpdate;
    }
}
