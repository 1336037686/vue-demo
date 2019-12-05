package com.boss.pojo.dto;

import lombok.Data;

/**
 * @author LGX_TvT
 * @date 2019-12-04 20:04
 */
@Data
public class UserBaseDTO {

    private String name;
    private String password;

    public UserBaseDTO() {
    }

    public UserBaseDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
