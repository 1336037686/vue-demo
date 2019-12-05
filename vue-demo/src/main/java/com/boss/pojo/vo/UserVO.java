package com.boss.pojo.vo;

import lombok.Data;

/**
 * @author LGX_TvT
 * @date 2019-12-04 21:59
 */
@Data
public class UserVO {
    private String ID;
    private String name;
    private Integer age;

    public UserVO() {
    }

    public UserVO(String ID, String name, Integer age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }
}
