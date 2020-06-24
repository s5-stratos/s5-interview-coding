package com.s5.interview.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import javax.annotation.Nonnull;

public class FlatMapIterator<A, B> implements Iterator<B> {

    public FlatMapIterator(@Nonnull Iterator<A> underlying, @Nonnull Function<A, Iterator<B>> mapFunc) {
        base = underlying;
        mapWith = mapFunc;
    }

    @Override
    public boolean hasNext() {
        buffer();
        // If we exhausted all items, then we will have a bufferedIterB leftover with
        // non
        // additional elements.
        // If we never got a first iterator because base was empty we may have a null
        // bufferedIterB
        return bufferedIterB != null && bufferedIterB.hasNext();
    }

    @Override
    public B next() {
        buffer();
        // We never managed to get an iterator to pump
        if (bufferedIterB == null) {
            throw new NoSuchElementException();
        }
        return bufferedIterB.next();
    }

    private Iterator<A> base;
    private Function<A, Iterator<B>> mapWith;
    private boolean isComplete;
    private Iterator<B> bufferedIterB;

    private void buffer() {
        while (!isComplete && (bufferedIterB == null || !bufferedIterB.hasNext())) {
            if (base.hasNext()) {
                bufferedIterB = mapWith.apply(base.next());
            } else {
                isComplete = true;
            }
        }
    }
}