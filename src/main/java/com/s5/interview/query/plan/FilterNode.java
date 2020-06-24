package com.s5.interview.query.plan;

import java.util.Map;
import java.util.function.Predicate;

import com.s5.interview.iter.FilterIterator;
import com.s5.interview.query.*;

/**
 * A plan Node that performs filtering on a node
 */
public class FilterNode implements Node {

    public FilterNode(Node base, FilterExpr filter) {
        underlying = base;
        filterExpr = filter;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private Node underlying;
    private FilterExpr filterExpr;

}