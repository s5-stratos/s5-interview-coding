package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.OrderedColumn;
import com.s5.interview.query.Row;
import com.s5.interview.query.Type;

public class StringEqExpr extends FilterExpr {
    public StringEqExpr(String col, String val) {
        column = col;
        value = val;
    }

    @Override
    public Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException {
        OrderedColumn col = metadata.findByName(column).orElseThrow(() -> new BadPlanException());
        if (col.getType() != Type.StringType) {
            throw new BadPlanException();
        }
        return (row) -> row.get(col.getIndex()).getString().equals(value);
    }

    private String column;
    private String value;
}