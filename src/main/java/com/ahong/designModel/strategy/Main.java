package com.ahong.designModel.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/8/12 11:31
 */
public class Main {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        String sql = "";
        String driverType = "MYSQL";
        AssembleSqlContext assembleSqlContext = null;
        switch (driverType){
            case "MYSQL":
                assembleSqlContext = new AssembleSqlContext(new AssembleMysqlById());
                break;
            case "ORACLE":
                assembleSqlContext = new AssembleSqlContext(new AssembleOracleById());
                break;
        }
        sql =  assembleSqlContext.assembleSql(map);
        System.out.println(sql);
    }
}
