package com.boss.pojo.vo;

import lombok.Data;

/**
 * @author LGX_TvT
 * @date 2019-12-04 22:50
 */
@Data
public class UserInsertVo {
    private String name;
    private String password;
    private Integer age;

    public UserInsertVo() {
    }

    public UserInsertVo(String name, String password, Integer age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
