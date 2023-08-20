package com.test;

import org.junit.Test;

import java.sql.*;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/18
 **/
public class TestTransaction {
    @Test
    public void testTransaction(){
        Connection connection = null;
        Statement statement = null;
        ResultSet execute = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://123.60.145.111:3306/test", "root", "jiejie");
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            String sql = "delete from student where name = '111'";
            int compareTo = statement.executeUpdate(sql);
            System.out.println("compareTo = " + compareTo);

            String update = "update student set name = 'jiejie' where student_id = 3";
            int executeUpdate = statement.executeUpdate(update);
            System.out.println("executeUpdate = " + executeUpdate);


            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null && statement != null && execute != null) {
                try {
                    connection.close();
                    statement.close();
                    execute.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
