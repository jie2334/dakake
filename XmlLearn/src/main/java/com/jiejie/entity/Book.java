package com.jiejie.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @description: Book类的实体
 * @author: 22783
 * @date: 2023/8/10
 **/
@Data
public class Book {

    private String id;

    private String author;

    private String title;

    private String genre;

    private float price;

    private LocalDate publishDate;

    private String description;


}
