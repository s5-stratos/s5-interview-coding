package com.s5.interview.query;

import java.util.ArrayList;
import java.util.Arrays;

public class Row {
    public Row(Value... vals) {
        values = vals;
    }

    public Value get(int i) {
        return values[i];
    }

    private Value[] values;

    public Row combine(Row other) {
        ArrayList<Value> vals = new ArrayList<>();
        vals.addAll(Arrays.asList(values));
        vals.addAll(Arrays.asList(other.values));
        return new Row(vals.toArray(new Value[vals.size()]));
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("row[");
        for (int i = 0; i < values.length; i++) {
            buffer.append(values[i].toString());
            if (i < values.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Row) {
            Row otherR = (Row) other;
            return Arrays.equals(values, otherR.values);
        }
        return false;
    }
}