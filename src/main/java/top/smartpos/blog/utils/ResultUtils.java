package top.smartpos.blog.utils;

import top.smartpos.blog.beans.protocol.Result;
import top.smartpos.blog.enums.ResultEnum;

/**
 * 请求结果封装工具类
 */
public class ResultUtils {
    /**
     * 请求成功，返回结果对象
     *
     * @param obj
     * @return
     */
    public static Result success(Object obj) {
        Result<Object> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(obj);
        return result;
    }

    /**
     * 请求成功，返回空对象
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 请求失败，返回失败状态码和提示信息
     *
     * @param resultEnum
     * @return
     */
    public static Result<String> error(ResultEnum resultEnum) {
        Result<String> result = new Result<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
}
