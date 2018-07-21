package top.smartpos.blog.exceptions;

import top.smartpos.blog.enums.ResultEnum;

/**
 * 所有可捕获异常都封装成自己的异常类，运行中异常可以让数据库事务回滚
 */
public class ApiException extends RuntimeException {
    /**
     * 错误状态枚举类型
     */
    private ResultEnum resultEnum;

    public ApiException() {
    }

    public ApiException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
    }

    public ApiException(ResultEnum resultEnum, Throwable cause) {
        super(resultEnum.getMsg(), cause);
        this.resultEnum = resultEnum;
    }

    public ApiException(ResultEnum resultEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(resultEnum.getMsg(), cause, enableSuppression, writableStackTrace);
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
