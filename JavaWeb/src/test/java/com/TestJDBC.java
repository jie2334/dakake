package com;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/17
 **/
public class TestJDBC {
    @Test
    public void test() {

        Connection connection = null;
        Statement statement = null;
        ResultSet execute = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            /*Driver driver = new Driver();*/

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123456");

            statement = connection.createStatement();

            String sql = "select * from student";

            execute = statement.executeQuery(sql);

            while (execute.next()) {
                System.out.println("studentId = " + execute.getString(1) + " studentName = " + execute.getString("studentName"));
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
