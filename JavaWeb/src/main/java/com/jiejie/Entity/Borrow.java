package com.jiejie.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    private int borrow_id;

    private int user_id;

    private int book_id;

    private Date borrow_date;

    private Date return_date;
}
