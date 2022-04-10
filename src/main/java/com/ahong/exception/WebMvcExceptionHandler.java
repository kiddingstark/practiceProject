package com.ahong.exception;

import com.ahong.PO.ResponsePo;
import com.ahong.enums.ResponseEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/8/6 19:02
 */

@RestControllerAdvice
@ResponseBody
public class WebMvcExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(WebMvcExceptionHandler.class);

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public WebMvcExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponsePo handleException(Exception exception, HttpServletRequest request) {
        log.warn("http request exception, uri={}, args={}, remoteIP={}", new Object[]{request.getRequestURI(), toJson(request.getParameterMap()), exception});
        return ResponsePo.fail(exception.getMessage());
    }

    @ExceptionHandler({ApplicationException.class})
    @ResponseBody
    public ResponsePo handleException(ApplicationException exception) {
        log.info("business exception, class={}, className={}", exception.getClass().getSimpleName(), exception);
        return ResponsePo.fail(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResponsePo handleException(MissingServletRequestParameterException exception, HttpServletRequest request) {
        log.warn("http request MissingServletRequestParameterException, uri={}, args={}, remoteIP={}", new Object[]{request.getRequestURI(), toJson(request.getParameterMap()), exception});
        return ResponsePo.fail(exception.getMessage());
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResponsePo handleException(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        log.warn("http request HttpRequestMethodNotSupportedException, uri={}, args={}, remoteIP={}", new Object[]{request.getRequestURI(), toJson(request.getParameterMap()), exception});
        return ResponsePo.fail(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponsePo handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        log.warn("http request MethodArgumentNotValidException, uri={}, args={}, remoteIP={}", new Object[]{request.getRequestURI(), toJson(request.getParameterMap()), exception});
        return ResponsePo.fail(ResponseEnum.FAIL.getCode(),exception.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler({BindException.class})
    @ResponseBody
    public ResponsePo handleBindException(BindException exception, HttpServletRequest request) {
        log.warn("http request BindException, uri={}, args={}", new Object[]{request.getRequestURI(), toJson(request.getParameterMap()), exception});
        return ResponsePo.fail(ResponseEnum.FAIL.getCode(), exception.getBindingResult().getFieldError().getDefaultMessage());
    }

    public static <T> String toJson(T value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (IOException var2) {
            log.error("序列化JSON出现异常，value={}", value, var2);
            return null;
        }
    }
}
