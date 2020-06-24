package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.OrderedColumn;
import com.s5.interview.query.Row;
import com.s5.interview.query.Type;

/**
 * A filter expression that checks String equality
 */
public class StringEqExpr extends FilterExpr {
    public StringEqExpr(String col, String val) {
        column = col;
        value = val;
    }

    @Override
    public Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private String column;
    private String value;
}