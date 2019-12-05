package com.boss.pojo.entity;

import lombok.Data;

/**
 * @author LGX_TvT
 * @date 2019-12-04 16:16
 */
@Data
public class User {

    private String id;
    private String name;
    private String password;
    private Integer age;

    public User() {
    }

    public User(String id, String name, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }



}


/**
具体表结构
USE vue_demo

CREATE TABLE USER(
    id VARCHAR(100) NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY(id)
)
*/