package com.yang.absence.handler;

import com.yang.absence.entity.common.Result;
import com.yang.absence.entity.common.ResultCode;
import com.yang.absence.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/21 22:21
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     *
     * @param e 异常信息
     * @return 统一返回值
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result handleServiceException(BusinessException e){
        log.error("出现业务异常", e);
        return new Result(ResultCode.ERROR, e.getMessage());
    }

    /**
     * 运行时异常
     * @param e 异常信息
     * @return 统一返回值
     */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Result handleArgsException(RuntimeException e){
        log.error("未知异常", e);
        return new Result(ResultCode.ERROR, "内部异常！");
    }
}
