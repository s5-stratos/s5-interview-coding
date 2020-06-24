package com.s5.interview.query;

import java.util.Collection;
import java.util.Iterator;

public class Table implements Iterable<Row> {
    public Table(Metadata metadata, Collection<Row> vals) {
        values = vals;
        this.metadata = metadata;
    }

    public Iterator<Row> iterator() {
        return values.iterator();
    }

    public Metadata getMetadata() {
        return metadata;
    }

    private Collection<Row> values;
    private Metadata metadata;
}