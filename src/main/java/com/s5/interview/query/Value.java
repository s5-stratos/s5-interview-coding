package com.s5.interview.query;

public class Value {
    public Value(String v) {
        type = Type.StringType;
        value = v;
    }

    public Value(double v) {
        type = Type.NumberType;
        value = v;
    }

    public Type getType() {
        return type;
    }

    public String getString() {
        return (String) value;
    }

    public double getNumber() {
        return ((Double) value).doubleValue();
    }

    private Type type;
    private Object value;

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Value) {
            return ((Value) other).value.equals(value);
        }
        return false;
    }
}