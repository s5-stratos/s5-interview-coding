package com.s5.interview.query.plan;

import java.util.function.Predicate;

import com.s5.interview.query.*;

/**
 * A filtering expression
 * 
 * Given input Metadata, a Row predicate may be constructed for use with
 * FilterNode
 */
public abstract class FilterExpr {
    public abstract Predicate<Row> createPredicate(Metadata metadata) throws BadPlanException;
}