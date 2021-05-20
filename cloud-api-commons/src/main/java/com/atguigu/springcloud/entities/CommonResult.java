package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 如果前后端分离，这个是提供给前端信息和数据的类
 *
 * @author sunxc
 * @date 2020/11/17 18:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404 not found

    private Integer code;
    private String message;

    /**
     * data
     */
    private T data;

    /**
     * 查询为空的时候使用的构造器
     *
     * @param code    code
     * @param message message
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
