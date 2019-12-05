package com.boss.pojo.dto;

import lombok.Data;

/**
 * @author LGX_TvT
 * @date 2019-12-04 21:40
 */
@Data
public class UserDTO {
    private String id;
    private String name;
    private String password;
    private Integer age;

    public UserDTO() {
    }

    public UserDTO(String id, String name, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
