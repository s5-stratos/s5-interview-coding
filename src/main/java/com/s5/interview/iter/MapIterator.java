package com.s5.interview.iter;

import java.util.Iterator;
import java.util.function.Function;

public class MapIterator<A, B> implements Iterator<B> {
    public MapIterator(Iterator<A> underlying, Function<A, B> mapFunc) {
        base = underlying;
        mapWith = mapFunc;
    }

    @Override
    public boolean hasNext() {
        return base.hasNext();
    }

    @Override
    public B next() {
        return mapWith.apply(base.next());
    }

    private Iterator<A> base;
    private Function<A, B> mapWith;
}