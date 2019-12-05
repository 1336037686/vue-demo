package com.boss.pojo.vo;

import lombok.Data;

/**
 * @author LGX_TvT
 * @date 2019-12-04 20:02
 */
@Data
public class UserBaseVO {
    private String name;
    private String password;

    public UserBaseVO() {
    }

    public UserBaseVO(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
