package com.s5.interview.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class Metadata {
    public Metadata(Collection<Column> cols) {
        this(cols.toArray(new Column[cols.size()]));
    }

    public Metadata(Column... cols) {
        columns = new OrderedColumn[cols.length];
        for (int i = 0; i < cols.length; i++) {
            columns[i] = new OrderedColumn(i, cols[i]);
        }
    }

    public int length() {
        return columns.length;
    }

    public OrderedColumn getColumn(int i) {
        return columns[i];
    }

    public Optional<OrderedColumn> findByName(String name) {
        for (int i = 0; i < columns.length; i++) {
            if (columns[i].getName().equals(name)) {
                return Optional.of(columns[i]);
            }
        }
        return Optional.empty();
    }

    private OrderedColumn[] columns;

    public Metadata combine(Metadata other) {
        ArrayList<Column> cols = new ArrayList<>();
        cols.addAll(Arrays.asList(columns));
        cols.addAll(Arrays.asList(other.columns));
        return new Metadata(cols);
    }

    public boolean equals(Object other) {
        if (other instanceof Metadata) {
            Metadata otherM = (Metadata) other;
            if (columns.length == otherM.columns.length) {
                for (int i = 0; i < columns.length; i++) {
                    Column selfI = columns[i];
                    Column otherI = otherM.columns[i];
                    if (!selfI.equals(otherI)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}