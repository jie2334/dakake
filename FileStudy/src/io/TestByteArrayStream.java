package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/3
 **/
public class TestByteArrayStream {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];

        for (int index = 0; index < bytes.length; index++) {
            bytes[index] = (byte)index;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int read = byteArrayInputStream.read();
        System.out.println("read = " + read);


        int read1 = byteArrayInputStream.read(bytes, 5, bytes.length - 5);
        System.out.println("read1 = " + read1);


        byteArrayInputStream.reset();
        System.out.println("byteArrayInputStream = " + byteArrayInputStream.read());
    }
}
