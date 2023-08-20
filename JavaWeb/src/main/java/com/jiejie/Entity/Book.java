package com.jiejie.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int book_id;

    private String book_name;

    private String author;

    private int book_number;

    private LocalDate publish_date;

    private String description;

    private Boolean is_borrow;

    private Boolean is_deleted;

}
