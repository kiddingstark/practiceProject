package com.ahong.designModel.strategy;

import java.util.Map;

/**
 * @Description 拼接sql的上下文context:注入算法属性后调用算法，屏蔽对算法的直接访问，解决多种if-else
 * @Author Ricky
 * @Date 2020/8/12 10:44
 */
public class AssembleSqlContext {

    private AssembleSqlSuper assembleSqlSuper;

    public AssembleSqlContext(AssembleSqlSuper assembleSqlSuper) {
        this.assembleSqlSuper = assembleSqlSuper;
    }

    public String assembleSql(Map<String,Object> map){
        return assembleSqlSuper.assembleSql(map);
    }
}
