package com.s5.interview.iter;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterIteratorTest {
    @Test
    public void filterOfEmptyIsEmpty() {
        ArrayList<Integer> ints = new ArrayList<>();
        Iterator<Integer> iter = new FilterIterator<>(ints.iterator(), (i) -> i % 2 == 0);
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, () -> iter.next());
    }

    @Test
    public void filterOfNonEmptyIsNonEmpty() {
        Iterator<Integer> base = Arrays.asList(1, 2, 3, 4).iterator();
        Iterator<Integer> filtered = new FilterIterator<>(base, (i) -> i % 2 == 0);
        assertEquals(Integer.valueOf(2), filtered.next());
        assertEquals(Integer.valueOf(4), filtered.next());
        assertFalse(filtered.hasNext());
    }

    @Test
    public void filterOfNonEmptyWithConstFalseIsEmpty() {
        Iterator<Integer> base = Arrays.asList(1, 2, 3, 4).iterator();
        Iterator<Integer> filtered = new FilterIterator<>(base, (i) -> false);
        assertFalse(filtered.hasNext());
        assertThrows(NoSuchElementException.class, () -> filtered.next());
    }
}