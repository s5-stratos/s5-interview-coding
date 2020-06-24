package com.s5.interview.iter;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMapIteratorTest {
    @Test
    public void flatMapOfEmptyIsEmpty() {
        Iterator<Integer> ints = Collections.emptyIterator();
        Iterator<Integer> iter = new FlatMapIterator<Integer, Integer>(ints, (i) -> Arrays.asList(i, -i).iterator());
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, () -> iter.next());
    }

    @Test
    public void flatMapOfNonEmpty() {
        Iterator<Integer> ints = Arrays.asList(1, 2).iterator();
        Iterator<Integer> iter = new FlatMapIterator<>(ints, (i) -> Arrays.asList(i, -i).iterator());
        assertEquals(Integer.valueOf(1), iter.next());
        assertEquals(Integer.valueOf(-1), iter.next());
        assertEquals(Integer.valueOf(2), iter.next());
        assertEquals(Integer.valueOf(-2), iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void flatMapSkipsNestedEmpty() {
        Iterator<Integer> ints = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> iter = new FlatMapIterator<>(ints,
                (i) -> i % 2 == 0 ? Collections.emptyIterator() : Arrays.asList(i, -i).iterator());
        assertEquals(Integer.valueOf(1), iter.next());
        assertEquals(Integer.valueOf(-1), iter.next());
        assertEquals(Integer.valueOf(3), iter.next());
        assertEquals(Integer.valueOf(-3), iter.next());
        assertFalse(iter.hasNext());
    }
}