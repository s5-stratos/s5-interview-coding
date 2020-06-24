package com.s5.interview.query;

public class OrderedColumn extends Column {
    public OrderedColumn(int i, String name, Type type) {
        super(name, type);
        index = i;
    }

    public OrderedColumn(int i, Column col) {
        super(col.getName(), col.getType());
        index = i;
    }

    public int getIndex() {
        return index;
    }

    private int index;

    @Override
    public boolean equals(Object other) {
        if (other instanceof OrderedColumn) {
            OrderedColumn otherC = (OrderedColumn) other;
            return getName().equals(otherC.getName()) && getType().equals(otherC.getType()) && index == otherC.index;
        }
        return false;
    }
}