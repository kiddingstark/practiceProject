package com.ahong.PO;

import com.ahong.enums.ResponseEnum;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/7/14 10:47
 */
public class ResponsePo<T> {

    private String message;

    private Integer code;

    private T data;

    public ResponsePo(Integer code,String message){
        this.data = null;
        this.code = code;
        this.message = message;
    }

    public ResponsePo(T data){
        this.data = data;
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
    }

    public ResponsePo(T data,String message){
        this.data = data;
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = message;
    }

    //需要有对应get与set方法才可进行json转换
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponsePo OK(){
        return new ResponsePo(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage());
    }

    public static <T> ResponsePo<T> success(T data){
        return new ResponsePo<T>(data);
    }

    public static <T> ResponsePo<T> success(T data,String message){
        return new ResponsePo<T>(data,message);
    }

    public static ResponsePo fail(){
        return new ResponsePo(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMessage());
    }

    public static <T> ResponsePo<T> fail(String message){
        return new ResponsePo<T>(ResponseEnum.FAIL.getCode(),message);
    }

    public static <T> ResponsePo<T> fail(Integer code, String message){
        return new ResponsePo<T>(code,message);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Result{code=");
        builder.append(this.code);
        if (this.message != null) {
            builder.append(", message='").append(this.message).append("'");
        }

        if (this.data != null) {
            builder.append(", data=").append(this.data);
        }

        builder.append("}");
        return builder.toString();
    }

}
