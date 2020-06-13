package com.github.jolice.citron.matcher.collection;

import java.util.Collection;
import java.util.function.BiPredicate;

public class OneOf<T> implements BiPredicate<T, Collection<? extends T>> {

    @Override
    public boolean test(T t, Collection<? extends T> ts) {
        return ts.contains(t);
    }


}
