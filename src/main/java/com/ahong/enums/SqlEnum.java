package com.ahong.enums;

/**
 * @Author lwj
 * @Date 2020/7/1 14:29
 */
public enum SqlEnum {

    Table("table","表名"),
    Columns("columns","列名"),
    Condition("condition","查询条件"),
    Order("order","排序字段"),
    Data("data","插入数据"),
    Limit("limit","limit个数"),
    PageNo("pageNo","页数"),
    PageSize("pageSize","每页数量"),
    TableId("id","主键ID"),
    IdColumn("idColumn","主键字段"),
    ColumnsMap("columnsMap","源表列名与目标表列名对应关系"),
    UpdateSet("updateSet","更新内容"),

    DeletedTable("deleted_table","删除的表"),
    DeletedId("deleted_id","删除的ID"),

    DriverType("driverType","驱动类型"),
    MYSQL("MYSQL","ORACLE驱动类型"),
    ORACLE("ORACLE","ORACLE驱动类型");

    private String code ;

    private String name;

    SqlEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
