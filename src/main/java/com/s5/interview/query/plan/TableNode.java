package com.s5.interview.query.plan;

import java.util.Map;
import com.s5.interview.query.*;

/**
 * A plan node that reads from a Table.
 * 
 * All leaf nodes in a Plan will be of this type
 */
public class TableNode implements Node {
    public TableNode(String name) {
        tableName = name;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private String tableName;
}