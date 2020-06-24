package com.s5.interview.query.plan;

import java.util.Map;

import com.s5.interview.query.*;

/**
 * An abstract query plan node
 */
public interface Node {
    public NodeResult execute(Map<String, Table> tables) throws BadPlanException;
}