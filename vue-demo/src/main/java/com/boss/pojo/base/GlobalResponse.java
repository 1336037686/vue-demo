package com.boss.pojo.base;

import lombok.Data;

/**
 * 返回报文
 * @author LGX_TvT
 * @date 2019-12-04 19:59
 */
@Data
public class GlobalResponse<T> {

    private Integer code;

    private T msg;

    public GlobalResponse(Integer code, T msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalResponse() {
    }
}
