package tech.bts.profeatweb.util.database;

public class SqlBuilder {

    private String sql;
    private int conditionCounter;

    public SqlBuilder() {
        this.conditionCounter = 0;
    }

    public SqlBuilder from(String table) {
        sql = "select * from " + table;
        return this;
    }

    public String build() {
        return this.sql;
    }

    public SqlBuilder where(String condition) {
        String prefix;

        if (conditionCounter == 0) {
            prefix = " where ";
        } else {
            prefix = " and ";
        }

        sql += prefix + condition;
        conditionCounter++;
        return this;
    }

    public SqlBuilder where(String column, String operator, Object value) {
        String valueStr;

        if (value instanceof String) {
            valueStr = "'" + value + "'";
        } else {
            valueStr = value.toString();
        }
        String condition = column + " " + operator + " " + valueStr;
        return where(condition);
    }
}
