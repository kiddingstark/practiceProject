package com.ahong.designModel.strategy;


import com.ahong.enums.SqlEnum;

import java.util.Map;

/**
 * @Description ID策略的oracle拼接
 * @Author Ricky
 * @Date 2020/8/12 10:53
 */
public class AssembleOracleById extends AssembleSqlSuper {

    @Override
    public String assembleSql(Map<String, Object> map) {
        Integer limit = (Integer) map.get(SqlEnum.Limit.getCode());
        String condition = map.get(SqlEnum.Condition.getCode()) + "";
        Long tableId = Long.valueOf(map.get(SqlEnum.TableId.getCode()).toString());
        String idColumn = SqlEnum.TableId.getCode();
        if (null != map.get(SqlEnum.IdColumn.getCode())) {
            idColumn = map.get(SqlEnum.IdColumn.getCode()).toString();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT " + map.get(SqlEnum.Columns.getCode()) + "," + idColumn + ",ROWNUM r");
        sql.append(" FROM " + map.get(SqlEnum.Table.getCode()));
        sql.append(" WHERE " + condition);
        sql.append(" AND " + idColumn + " > " + tableId);
        sql.append(" AND ROWNUM <= " + limit);
        sql.append(" ORDER BY " + map.get(SqlEnum.Order.getCode()));
        return sql.toString();
    }
}
