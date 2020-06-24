package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.OrderedColumn;
import com.s5.interview.query.Row;

public class NumberEqExpr extends FilterExpr {
    public NumberEqExpr(String col, double val) {
        column = col;
        value = val;
    }

    @Override
    public Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private String column;
    private double value;
}