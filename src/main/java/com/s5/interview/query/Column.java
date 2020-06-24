package com.s5.interview.query;

public class Column {
    public Column(String name, Type type) {
        columnName = name;
        columnType = type;
    }

    public String getName() {
        return columnName;
    }

    public Type getType() {
        return columnType;
    }

    private String columnName;
    private Type columnType;

    @Override
    public boolean equals(Object other) {
        if (other instanceof Column) {
            Column otherC = (Column) other;
            return columnName.equals(otherC.columnName) && columnType.equals(otherC.columnType);
        }
        return false;
    }
}