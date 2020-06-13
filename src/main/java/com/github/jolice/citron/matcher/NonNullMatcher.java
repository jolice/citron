package com.github.jolice.citron.matcher;

public class NonNullMatcher<T> implements Matcher<T> {

    private final T actual;

    public NonNullMatcher(T actual) {
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return actual != null;
    }

    @Override
    public String mismatchDescription() {
        return "Expected any non-null reference, but the actual value is null";
    }
}
