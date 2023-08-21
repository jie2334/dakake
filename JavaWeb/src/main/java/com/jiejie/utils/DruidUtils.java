package com.jiejie.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 测试druid连接池
 * @author: 22783
 * @date: 2023/8/17
 **/
public class DruidUtils {
    private static DataSource dataSource;
    static {

        InputStream resource = null;
        try{
            Properties properties = new Properties();
            resource = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resource);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                resource.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
