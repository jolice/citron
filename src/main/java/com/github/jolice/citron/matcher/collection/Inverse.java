package com.github.jolice.citron.matcher.collection;

import java.util.function.BiPredicate;

public class Inverse<T, U> implements BiPredicate<T, U> {

    private final BiPredicate<T, U> predicate;

    public Inverse(BiPredicate<T, U> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(T t, U u) {
        return !predicate.test(t, u);
    }
}
