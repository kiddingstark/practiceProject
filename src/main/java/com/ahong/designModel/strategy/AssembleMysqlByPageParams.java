package com.ahong.designModel.strategy;


import com.ahong.enums.SqlEnum;

import java.util.Map;

/**
 * @Description 分页参数策略的mysql拼接
 * @Author Ricky
 * @Date 2020/8/12 11:12
 */
public class AssembleMysqlByPageParams extends AssembleSqlSuper {

    @Override
    public String assembleSql(Map<String, Object> map) {
        Integer pageNo = (Integer) map.get(SqlEnum.PageNo.getCode());
        Integer pageSize = (Integer) map.get(SqlEnum.PageSize.getCode());
        String condition = map.get(SqlEnum.Condition.getCode()) + "";
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT " + map.get(SqlEnum.Columns.getCode()));
        sql.append(" FROM " + map.get(SqlEnum.Table.getCode()));
        sql.append(" WHERE " + condition);
        sql.append(" ORDER BY " + map.get(SqlEnum.Order.getCode()));
        sql.append(" LIMIT " + (pageNo - 1) * pageSize + "," + pageSize);
        return sql.toString();
    }
}
