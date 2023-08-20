package com.test;

import com.jiejie.utils.DruidUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/18
 **/
public class TestPrepareStatement {

    @Test
    public void testPreStatement(){
        //sql语句执行之前会先放到数据库里面预编译，逻辑关系不会改变

        String sql = "select * from student where student_id = ?";
        try {
            Connection connection = DruidUtils.getDataSource().getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1,1);

            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("resultSet: "+ resultSet.getInt("student_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
