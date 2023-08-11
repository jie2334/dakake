package com.jiejie;

import com.jiejie.entity.Book;
import com.jiejie.entity.Catalog;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @description: TestCatalog
 * @author: 22783
 * @date: 2023/8/10
 **/
public class TestCatalog {

    /*修改文件、读文件、将文件转换成对象打印出来*/

    //将xml文件读出来，打印在控制台
    @Test
    public void testReadeXml() {

        String filePath = "E:\\dakake\\XmlLearn\\src\\main\\resources\\catalog.xml";
        SAXReader saxReader = new SAXReader();

        try {
            //根节点
            Document document = saxReader.read(filePath);

            Element rootElement = document.getRootElement();

            System.out.println("rootElement = " + rootElement.getName());

            Iterator iterator = rootElement.elementIterator();

            //book元素
            while (iterator.hasNext()) {
                Element element = (Element) iterator.next();
                //book元素集合
                List<Attribute> attributes = element.attributes();
                for (Attribute attribute : attributes) {
                    System.out.println("节点名 = " + attribute.getName() + " 节点值: " + attribute.getValue());
                }

                //迭代元素book后面的元素
                Iterator elemented = element.elementIterator();
                while (elemented.hasNext()) {
                    Element o = (Element) elemented.next();
                    System.out.println("属性名：" + o.getName() + " 属性值: " + o.getText());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //测试修改xml文件的方法
    @Test
    public void testRevise() {

        try {
            String filePath = "E:\\dakake\\XmlLearn\\src\\main\\resources\\catalog.xml";
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(filePath);


            Element rootElement = document.getRootElement();

            List<Node> nodes = document.selectNodes("/catalog/book[@id='bk101']");
            //遍历node
            for (Node node : nodes) {
                Element element = (Element) node;
                Iterator iterator = element.elementIterator("genre");
                while (iterator.hasNext()) {
                    Element next = (Element) iterator.next();
                    next.setText("Basketball");
                }
            }
            //输赢IO流写入属性

            //设置输入的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter(System.out, format);
            writer.write(document);

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //测试将xml中的book转换成对象打印
    @Test
    public void testPrint() {


        //第一步先获取xml文件
        try {
            String filePath = "E:\\dakake\\XmlLearn\\src\\main\\resources\\catalog.xml";
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(filePath);

            Element rootElement = document.getRootElement();

            //找到id为101的书籍，获取所有的节点
            List<Node> nodes = document.selectNodes("/catalog/book[@id='bk101']");

            Book book = new Book();

            //转成Book对象
            nodes.forEach(node -> {
                Element element = (Element) node;
                book.setId(element.attributeValue("id"));
                book.setAuthor(element.elementText("author"));
                book.setTitle(element.elementText("title"));
                book.setGenre(element.elementText("genre"));
                book.setPrice(Float.parseFloat(element.elementText("price")));
                book.setPublishDate(LocalDate.parse(element.elementText("publish_date")));
                book.setDescription(element.elementText("description"));
            });

            System.out.println("book = " + book);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
