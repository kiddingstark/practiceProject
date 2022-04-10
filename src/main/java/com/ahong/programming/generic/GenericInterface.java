package com.ahong.programming.generic;

/**
 * @Description 泛型接口的意义：实现参数通用化，不同的类继承此泛型接口可传入不同的数据类型
 * @Author zheng_ruihong
 * @Date 2020/7/14 10:07
 */
public interface GenericInterface<T> {
    public T next();
}
