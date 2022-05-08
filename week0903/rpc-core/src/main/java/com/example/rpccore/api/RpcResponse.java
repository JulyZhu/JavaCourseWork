package com.example.rpccore.api;

import lombok.Data;

/**
 * @author zhujun
 */
@Data
public class RpcResponse {
    /**
     * 响应结果
     */
    private Object result;

    /**
     * 函数是否执行成功
     */
    private Boolean status;

    /**
     * 执行失败的异常信息
     */
    private Exception exception;
}
