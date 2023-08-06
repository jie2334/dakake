package com.jiejie;

import com.jiejie.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @description: 单元测试
 * @author: 22783
 * @date: 2023/8/4
 **/
public class TestUnit {


    @Resource
    User user = new User("杰杰", "花城大道", 21);

    @Test
    public void test() {
        System.out.println("单元测试开始进行!");
        String address = user.getAddress();
        System.out.println("address = " + address);
    }

    @Test
    public void testUnit() {
        String name = user.getName();
        System.out.println("name = " + name);

    }

    @Before
    public void testBefore(){
        System.out.println("test--------------------Before!");
    }

    @After
    public void testAfter(){
        System.out.println("test--------------------After!");
    }



    @Test
    public void testSocket() throws IOException {

    }

}
