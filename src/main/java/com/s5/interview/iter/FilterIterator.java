package com.s5.interview.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public final class FilterIterator<A> implements Iterator<A> {
    public FilterIterator(Iterator<A> underlying, Predicate<A> pred) {

    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public A next() {
        throw new UnsupportedOperationException("Implement me!");
    }
}