package com.ahong.designModel.strategy;

import java.util.Map;

/**
 * @Description 拼接sql的抽象策略类
 * @Author Ricky
 * @Date 2020/8/12 10:44
 */
public abstract class AssembleSqlSuper {

    public abstract String assembleSql(Map<String, Object> map);
}
