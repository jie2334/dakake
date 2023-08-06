package library;

import java.util.List;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/26
 **/
public class Library {

    private String name;

    private String address;

    private List<Book> bookList;


    public Library(String name, String address, List<Book> bookList) {
        this.name = name;
        this.address = address;
        this.bookList = bookList;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bookList=" + bookList +
                '}';
    }


}
