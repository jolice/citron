package com.github.jolice.citron.matcher;

import java.util.function.Predicate;

public class PredicateMatcher<T> implements Matcher<T> {

    private final Predicate<T> predicate;
    private final T actual;

    public PredicateMatcher(Predicate<T> predicate, T actual) {
        this.predicate = predicate;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return predicate.test(actual);
    }

    @Override
    public String mismatchDescription() {
        return String.format("Object [%s] does not match an expected predicate", actual);
    }
}
