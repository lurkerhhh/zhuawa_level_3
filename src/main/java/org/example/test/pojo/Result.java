package org.example.test.pojo;

import lombok.Data;

/**
 *  响应结果类（用泛型封装）
 */
@Data
public class Result<T> {
    private Integer code;    //状态码
    private Boolean success; //是否成功
    private T data;          //数据

    private Result() {
    }

    /**
     * 成功：带有数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.code = 200;
        r.success = true;
        r.data = data;
        return r;
    }

    /**
     * 失败：带有状态码
     */
    public static <T> Result<T> failure(Integer code) {
        Result<T> r = new Result<>();
        r.code = code;
        r.success = false;
        return r;
    }

    /**
     * 失败：带有状态码和数据
     */
    public static <T> Result<T> failure(Integer code, T data) {
        Result<T> r = new Result<>();
        r.code = code;
        r.success = false;
        r.data = data;
        return r;
    }
}
