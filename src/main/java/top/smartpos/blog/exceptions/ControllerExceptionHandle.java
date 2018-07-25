package top.smartpos.blog.exceptions;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.smartpos.blog.beans.protocol.Result;
import top.smartpos.blog.enums.ResultEnum;
import top.smartpos.blog.utils.LogUtils;
import top.smartpos.blog.utils.ResultUtils;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
/**
 * 捕获所有controller中抛出的异常
 */
public class ControllerExceptionHandle {
    @ExceptionHandler(value = Throwable.class)
    public Result handle(Throwable e) {
        //手动抛出的异常
        if (e instanceof ApiException) {//自己封装的异常，为已知异常，异常内容正常返回前端
            ApiException apiException = (ApiException) e;
            return ResultUtils.error(apiException.getResultEnum());
        }
//        MissingServletRequestParameterException
        LogUtils.error(e.getMessage(), e);
        if (!(e instanceof MethodArgumentNotValidException)) return ResultUtils.error(ResultEnum.UNKOWN_ERROR);
        //验证参数的异常
        BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        if (!bindingResult.hasErrors()) return ResultUtils.error(ResultEnum.UNKOWN_ERROR);
        List<ObjectError> errorList = bindingResult.getAllErrors();
        List<String> errors = new ArrayList<>();
        for (ObjectError error : errorList) {
            errors.add(error.getDefaultMessage());
        }
        //输出验证异常信息，多个信息用逗号分隔
        ResultEnum.UNKOWN_ERROR.setMsg(StringUtils.join(errors, ","));
        return ResultUtils.error(ResultEnum.UNKOWN_ERROR);
    }
}
