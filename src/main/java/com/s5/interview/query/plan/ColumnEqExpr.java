package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.OrderedColumn;
import com.s5.interview.query.Row;

public class ColumnEqExpr extends FilterExpr {
    public ColumnEqExpr(String l, String r) {
        left = l;
        right = r;
    }

    @Override
    public Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException {
        OrderedColumn leftCol = metadata.findByName(left).orElseThrow(() -> new BadPlanException());
        OrderedColumn rightCol = metadata.findByName(right).orElseThrow(() -> new BadPlanException());
        return (row) -> row.get(leftCol.getIndex()).equals(row.get(rightCol.getIndex()));
    }

    private String left;
    private String right;

}