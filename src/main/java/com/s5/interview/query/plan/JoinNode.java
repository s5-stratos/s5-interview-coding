package com.s5.interview.query.plan;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

import com.s5.interview.iter.FlatMapIterator;
import com.s5.interview.iter.MapIterator;
import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.Row;
import com.s5.interview.query.Table;

/**
 * A plan node that performs cross joins on two nodes
 */
public class JoinNode implements Node {

    public JoinNode(Node left, Node right) {
        leftNode = left;
        rightNode = right;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        throw new UnsupportedOperationException("Implement me");
    }

    private Node leftNode;
    private Node rightNode;

}