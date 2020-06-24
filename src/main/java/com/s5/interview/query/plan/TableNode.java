package com.s5.interview.query.plan;

import java.util.Map;
import com.s5.interview.query.*;

public class TableNode implements Node {
    public TableNode(String name) {
        tableName = name;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        Table table = tables.get(tableName);
        if (table == null) {
            throw new BadPlanException();
        }
        return new NodeResult(table.getMetadata(), () -> table.iterator());
    }

    private String tableName;
}