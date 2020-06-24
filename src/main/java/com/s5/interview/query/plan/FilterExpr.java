package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.*;

public abstract class FilterExpr {
    public abstract Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException;
}