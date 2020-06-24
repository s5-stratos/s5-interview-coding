package com.s5.interview.query.plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;

import com.s5.interview.query.BadPlanException;
import com.s5.interview.query.Column;
import com.s5.interview.query.Metadata;
import com.s5.interview.query.Row;
import com.s5.interview.query.Table;
import com.s5.interview.query.Type;
import com.s5.interview.query.Value;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlanTest {
    @Test
    public void testComplexQuery() throws BadPlanException {
        /**
         * Appriximates the following: SELECT age FROM people CROSS JOIN hometowns WHERE
         * hometowns.person = people.name AND hometowns.hometown = 'Ann Arbor'
         */

        Node plan = new ProjectNode(new String[] { "age" },
                new FilterNode(new FilterNode(new JoinNode(new TableNode("people"), new TableNode("hometowns")),
                        new ColumnEqExpr("name", "person")), new StringEqExpr("hometown", "Ann Arbor")));

        HashMap<String, Table> tables = new HashMap<>();
        tables.put("people", makePeople());
        tables.put("hometowns", makeHometowns());

        NodeResult result = plan.execute(tables);
        Metadata metadata = result.getMetadata();
        assertEquals(new Metadata(new Column("age", Type.NumberType)), metadata);
        ArrayList<Row> rows = new ArrayList<Row>();
        for (Row r : result) {
            rows.add(r);
        }

        ArrayList<Row> expected = new ArrayList<Row>();
        expected.addAll(Arrays.asList(new Row(new Value(30)), new Row(new Value(35))));

        assertEquals(expected, rows);

    }

    public Table makePeople() {
        Metadata metadata = new Metadata(new Column("name", Type.StringType), new Column("age", Type.NumberType));
        ArrayList<Row> rows = new ArrayList<>();
        rows.add(new Row(new Value("Charlee"), new Value(30)));
        rows.add(new Row(new Value("DeMarcus"), new Value(35)));
        rows.add(new Row(new Value("Reily"), new Value(24)));
        rows.add(new Row(new Value("Aleksander"), new Value(8)));
        return new Table(metadata, rows);
    }

    public Table makeHometowns() {
        Metadata metadata = new Metadata(new Column("person", Type.StringType),
                new Column("hometown", Type.StringType));
        ArrayList<Row> rows = new ArrayList<>();
        rows.add(new Row(new Value("Charlee"), new Value("Ann Arbor")));
        rows.add(new Row(new Value("DeMarcus"), new Value("Ann Arbor")));
        rows.add(new Row(new Value("Reily"), new Value("Waco")));
        rows.add(new Row(new Value("Aleksander"), new Value("Bright Falls")));
        return new Table(metadata, rows);
    }
}