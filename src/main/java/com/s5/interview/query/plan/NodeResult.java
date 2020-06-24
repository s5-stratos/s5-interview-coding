package com.s5.interview.query.plan;

import java.util.Iterator;
import java.util.function.Supplier;

import com.s5.interview.query.*;

/**
 * A holder of intermediate node results that form during the execution of a
 * plan.Node
 */
public class NodeResult implements Iterable<Row> {
    public NodeResult(Metadata metadata, Supplier<Iterator<Row>> rows) {
        resultMetadata = metadata;
        resultRows = rows;
    }

    public Metadata getMetadata() {
        return resultMetadata;
    }

    public Iterator<Row> iterator() {
        return resultRows.get();
    }

    public Supplier<Iterator<Row>> getSupplier() {
        return resultRows;
    }

    private Metadata resultMetadata;
    private Supplier<Iterator<Row>> resultRows;
}