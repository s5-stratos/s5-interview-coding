package com.s5.interview.iter;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MapIteratorTest {
    @Test
    public void mapOfEmptyIsEmpty() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<String> mapped = new MapIterator<>(empty, (i) -> i.toString());
        assertFalse(mapped.hasNext());
        assertThrows(NoSuchElementException.class, () -> mapped.next());
    }

    @Test
    public void mapOfNonEmptyIsNonEmpty() {
        Iterator<Integer> iter = Arrays.asList(1, 2, 3).iterator();
        Iterator<String> mapped = new MapIterator<>(iter, i -> i.toString());
        assertEquals("1", mapped.next());
        assertEquals("2", mapped.next());
        assertEquals("3", mapped.next());
        assertFalse(mapped.hasNext());
    }
}