package com.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jiejie.utils.DruidUtils;
import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/17
 **/
public class TestJDBC {
    @Test
    public void testConnection() {

        Connection connection = null;
        Statement statement = null;
        ResultSet execute = null;
        try {

            //Class.forName("com.mysql.cj.jdbc.Driver");
            //从Java6开始可以不加载驱动

            /*Driver driver = new Driver();*/

            connection = DriverManager.getConnection("jdbc:mysql://123.60.145.111:3306/test", "root", "jiejie");

            statement = connection.createStatement();

            String sql = "select * from student";

            execute = statement.executeQuery(sql);

            while (execute.next()) {
                System.out.println("studentId = " + execute.getString(1) + "; studentName" + execute.getString("name") + ";studentMath= " + execute.getString("math") + ";English = " + execute.getString(3) + "; physical: " + execute.getString(4));
                System.out.println();

            }

            /*String sqlUpdate = "insert into student values (null,125,100,90,60,'Jack',123141331)";

            int compareTo = statement.executeUpdate(sqlUpdate);

            System.out.println("compareTo = " + compareTo);*/
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
    @Test
    public void testCreateTable(){
        try{
            DataSource dataSource = DruidUtils.getDataSource();
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            /*String sql = "create database jiejie";

            //创建数据库语句
            int compareTo = statement.executeUpdate(sql);
            System.out.println("compareTo = " + compareTo);*/

            //创建表语句
            String table = "create table db_user (username varchar(255) not null primary key,password varchar(255) not null)";
            int createTable = connection.createStatement().executeUpdate(table);
            System.out.println("createTable = " + createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testUpdate() {
        Connection connection = null;
        Statement statement = null;
        ResultSet execute = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://123.60.145.111:3306/test", "root", "jiejie");

            statement = connection.createStatement();

            String sql = "update student set name = '胡歌' where student_id = 5";

            int compareTo = statement.executeUpdate(sql);

            System.out.println("compareTo = " + compareTo);
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

    @Test
    public void testDelete() {
        Connection connection = null;
        Statement statement = null;
        ResultSet execute = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://123.60.145.111:3306/test", "root", "jiejie");

            statement = connection.createStatement();

            String sql = "delete from student where name = '小红'";
            int compareTo = statement.executeUpdate(sql);

            System.out.println("compareTo = " + compareTo);
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





    /**
     * 前面是使用JDBC实现CRUD,现在使用Druid连接池实现
     */

    @Test
    public void testDruidBySet() {
        DruidDataSource dataSource = null;

        try {
            dataSource = new DruidDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://123.60.145.111:3306/test");
            dataSource.setUsername("root");
            dataSource.setPassword("jiejie");


            //初始大小
            dataSource.setInitialSize(10);
            //最大大小
            dataSource.setMaxActive(50);
            //最小大小
            dataSource.setMinIdle(10);
            //检查时间
            dataSource.setMaxWait(5000);

            DruidPooledConnection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("studentId = " + resultSet.getString(1) + "; studentName" + resultSet.getString("name") + ";studentMath= " + resultSet.getString("math") + ";English = " + resultSet.getString(3) + "; physical: " + resultSet.getString(4));
                System.out.println();

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert dataSource != null;
            dataSource.close();
        }
    }

    @Test
    public void testDruidByProperties() {

        try {
            Properties properties = new Properties();

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("E:\\dakake\\JavaWeb\\src\\main\\resources\\druid.properties"));

            properties.load(inputStreamReader);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where student_id = '1'");


            while (resultSet.next()) {
                System.out.println("studentId = " + resultSet.getString(1) + "; studentName" + resultSet.getString("name") + ";studentMath= " + resultSet.getString("math") + ";English = " + resultSet.getString(3) + "; physical: " + resultSet.getString(4));
                System.out.println();

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    /*封装druid连接池*/
    @Test
    public void testDruidEncapsulation() {
        try {
            DataSource dataSource = DruidUtils.getDataSource();
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where student_id = '1'");

            while (resultSet.next()) {
                System.out.println("studentId = " + resultSet.getString(1) + "; studentName" + resultSet.getString("name") + ";studentMath= " + resultSet.getString("math") + ";English = " + resultSet.getString(3) + "; physical: " + resultSet.getString(4));
                System.out.println();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testColumnIndex() {
        String sql = "INSERT INTO student(student_id,math,book_id)  VALUES (?,?,?)";
        int[] columnIndexes = {1,2,7}; // 设置要存储结果的列的索引

        try (Connection connection = DruidUtils.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, columnIndexes)) {
            preparedStatement.setInt(1, 25); // 设置第一个参数的值
            preparedStatement.setInt(2, 10);
            preparedStatement.setInt(3, 110086);// 设置第二个参数的值

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("受影响的行数：" + rowsAffected);

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                // 遍历生成的键值
                  System.out.println("生成的键值：" + generatedKeys.getObject(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
