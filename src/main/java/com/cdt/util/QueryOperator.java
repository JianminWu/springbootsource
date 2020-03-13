package com.cdt.util;

public enum QueryOperator {

    /**
     * 等于
     */
    EQ(" = "),
    /**
     * 不等于
     */
    NEQ(" != "),
    /**
     * like %v%
     */
    LIKE(" LIKE "),
    /**
     * like %v
     */
    LLIKE(" LIKE "),
    /**
     * like v%
     */
    RLIKE(" LIKE "),
    /**
     * 大于
     */
    GT(" > "),
    /**
     * 小于
     */
    LT(" < "),
    /**
     * 大于等于
     */
    GTE(" >= "),
    /**
     * 小于等于
     */
    LTE(" <= "),
    /**
     * 包含
     */
    IN(" IN "),
    /**
     * 不包含
     */
    NOTIN(" NOT IN "),
    /**
     * 为空
     */
    NULL(" IS NULL "),
    /**
     * 不为空
     */
    NOTNULL(" IS NOT NULL "),
    ;
    private String sqlOperator;

    QueryOperator(String sqlOperator) {
        this.sqlOperator = sqlOperator;
    }

    public String getSqlOperator() {
        return sqlOperator;
    }
}