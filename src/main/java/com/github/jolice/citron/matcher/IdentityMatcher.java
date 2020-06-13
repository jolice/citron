package com.github.jolice.citron.matcher;

public class IdentityMatcher<T> implements Matcher<T> {

    private final T expected;
    private final T actual;

    public IdentityMatcher(T expected, T actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return expected == actual;
    }

    @Override
    public String mismatchDescription() {
        return String.format("References do not point at the same object. Expected reference #%d points to (%s), but actual #%d points to (%s)",
                System.identityHashCode(expected),
                expected,
                System.identityHashCode(actual),
                actual);
    }
}
