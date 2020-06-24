package com.s5.interview.query.plan;

import java.util.Map;
import java.util.function.Predicate;

import com.s5.interview.iter.FilterIterator;
import com.s5.interview.query.*;

public class FilterNode implements Node {

    public FilterNode(Node base, FilterExpr filter) {
        underlying = base;
        filterExpr = filter;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        NodeResult intermediate = underlying.execute(tables);
        Metadata metadata = intermediate.getMetadata();
        Predicate<Row> filter = filterExpr.createPredicate(intermediate.getMetadata());
        return new NodeResult(metadata, () -> new FilterIterator<>(intermediate.iterator(), filter));
    }

    private Node underlying;
    private FilterExpr filterExpr;

}