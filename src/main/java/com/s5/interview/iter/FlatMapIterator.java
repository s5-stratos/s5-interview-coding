package com.s5.interview.iter;

import java.util.Iterator;
import java.util.function.Function;

public class FlatMapIterator<A, B> implements Iterator<B> {

    public FlatMapIterator(Iterator<A> underlying, Function<A, Iterator<B>> mapFunc) {
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public B next() {
        throw new UnsupportedOperationException("Implement me");
    }
}