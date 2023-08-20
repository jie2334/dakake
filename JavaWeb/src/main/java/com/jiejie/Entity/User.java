package com.jiejie.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;

    private String username;

    private String sex;

    private int age;

    private String information;
}
