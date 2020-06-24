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

public class JoinNode implements Node {

    public JoinNode(Node left, Node right) {
        leftNode = left;
        rightNode = right;
    }

    @Override
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException {
        NodeResult leftResult = leftNode.execute(tables);
        NodeResult rightResult = rightNode.execute(tables);

        Metadata metadata = leftResult.getMetadata().combine(rightResult.getMetadata());
        Supplier<Iterator<Row>> rows = () -> new FlatMapIterator<>(leftResult.iterator(),
                (left) -> new MapIterator<>(rightResult.iterator(), (right) -> left.combine(right)));

        return new NodeResult(metadata, rows);
    }

    private Node leftNode;
    private Node rightNode;

}