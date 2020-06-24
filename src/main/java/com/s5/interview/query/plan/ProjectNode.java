package com.s5.interview.query.plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.s5.interview.iter.MapIterator;
import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Column;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.Row;
import com.s5.interview.query.Table;
import com.s5.interview.query.Value;

/**
 * A plan node that performs projection (think SELECT)
 */
public class ProjectNode implements Node {

    public ProjectNode(String[] cols, Node base) {
        columns = new HashSet<>(Arrays.asList(cols));
        underlying = base;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private Set<String> columns;
    private Node underlying;
}