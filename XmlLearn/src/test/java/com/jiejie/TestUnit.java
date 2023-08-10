package com.jiejie;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/10
 **/
public class TestUnit {
    @Test
    public void testXml() {

        String path = "E:\\dakake\\XmlLearn\\src\\main\\resources\\test.xml";

        SAXReader saxReader = new SAXReader();

        try {
            //根节点
            Document document = saxReader.read(path);

            Element rootElement = document.getRootElement();

            System.out.println("rootElement = " + rootElement.getName());

            Iterator iterator = rootElement.elementIterator();

            while(iterator.hasNext()){
                Element element = (Element) iterator.next();

                List<Attribute> attributes = element.attributes();
                for(Attribute attribute:attributes){
                    System.out.println("节点名 = " + attribute.getName()+"节点值: "+attribute.getValue());
                }

                //迭代元素后面的元素
                Iterator elemented = element.elementIterator();
                while (elemented.hasNext()){
                    Element o = (Element) elemented.next();
                    System.out.println("属性名："+o.getName()+"属性值: "+o.getText());
                }
            }

            Element element = rootElement.addElement("jiejie");
            element.addAttribute("hobby","basketball");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




}
