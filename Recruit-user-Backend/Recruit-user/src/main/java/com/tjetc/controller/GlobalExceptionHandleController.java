package com.tjetc.controller;
import com.tjetc.common.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//处理异常优先级：能被子类异常处理不会走父类异常实例，能被局部异常处理就不会走全局异常处理
//全局异常处理
@RestControllerAdvice//@RestController+@ResponseBoby
@Slf4j
public class GlobalExceptionHandleController {
    @ExceptionHandler({ArithmeticException.class})
    public JsonResult arithmetic(ArithmeticException e){
        //记录日志
        log.error(e.toString());
        //组装对象返回json
        JsonResult jsonResult = new JsonResult(1, e.getMessage(),null);
        return  jsonResult;
    }
}
