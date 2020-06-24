package com.s5.interview.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;

import com.google.common.base.Predicate;

public final class FilterIterator<A> implements Iterator<A> {
    public FilterIterator(@Nonnull Iterator<A> underlying, Predicate<A> pred) {
        base = underlying;
        predicate = pred;
        isComplete = false;
    }

    @Override
    public boolean hasNext() {
        buffer();
        return bufferedA != null;
    }

    @Override
    public A next() {
        buffer();
        if (bufferedA == null) {
            throw new NoSuchElementException();
        }
        // Consume the buffered value
        A nextA = bufferedA;
        bufferedA = null;
        return nextA;
    }

    private Iterator<A> base;
    private Predicate<A> predicate;
    private boolean isComplete;
    private A bufferedA;

    private void buffer() {
        // By we start in an uninitialized state where isComplete is false and
        // buffered = null;
        while (!isComplete && bufferedA == null) {
            if (base.hasNext()) {
                A nextA = base.next();
                if (predicate.apply(nextA)) {
                    bufferedA = nextA;
                }
            } else {
                isComplete = true;
            }
        }
    }

}