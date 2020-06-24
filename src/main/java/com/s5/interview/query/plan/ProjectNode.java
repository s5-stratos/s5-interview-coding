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

public class ProjectNode implements Node {

    public ProjectNode(String[] cols, Node base) {
        columns = new HashSet<>(Arrays.asList(cols));
        underlying = base;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        NodeResult intermediate = underlying.execute(tables);
        Metadata metadata = intermediate.getMetadata();
        // Such inefficiency... shrug
        // Duplicate columns... shrug
        int[] prjColIdxs = new int[columns.size()];
        ArrayList<Column> prjCols = new ArrayList<>(columns.size());
        int j = 0;
        for (int i = 0; i < metadata.length(); i++) {
            Column colI = metadata.getColumn(i);
            if (columns.contains(colI.getName())) {
                prjCols.add(colI);
                prjColIdxs[j++] = i;
            }
        }
        if (j != columns.size()) {
            throw new BadPlanException();
        }
        Metadata projected = new Metadata(prjCols);
        Supplier<Iterator<Row>> supplier = () -> new MapIterator<>(intermediate.iterator(), (row) -> {
            Value[] vals = new Value[columns.size()];
            int k = 0;
            for (int col : prjColIdxs) {
                vals[k++] = row.get(col);
            }
            return new Row(vals);
        });
        return new NodeResult(projected, supplier);
    }

    private Set<String> columns;
    private Node underlying;
}