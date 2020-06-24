package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.OrderedColumn;
import com.s5.interview.query.Row;

/**
 * A FilterExpr that compares the value in one column to the value in another
 */
public class ColumnEqExpr extends FilterExpr {
    public ColumnEqExpr(String l, String r) {
        left = l;
        right = r;
    }

    @Override
    public Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private String left;
    private String right;

}