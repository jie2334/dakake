package library;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

/**
 * @description: 书籍类
 * @author: 22783
 * @date: 2023/7/26
 **/
public class Book {

    private String name;

    private String author;
    //出版日期
    private  Date publicationDate;
    //借阅日期
    private  Date StorageDate;

    private boolean isBorrow;


    public Book(String name, String author, Date publicationDate,  boolean isBorrow) {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isBorrow = isBorrow;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getStorageDate() {
        return StorageDate;
    }

    public void setStorageDate(Date storageDate) {
        StorageDate = storageDate;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name= '" + name + '\'' +
                ", author= '" + author + '\'' +
                ", publicationDate= " + publicationDate +
                ", StorageDate= " + StorageDate +
                ", isBorrow= " + isBorrow +
                '}';
    }

}
