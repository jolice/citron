package io.riguron.citron.matcher;

public class NullMatcher<T> implements Matcher<T> {

    private final T actual;

    public NullMatcher(T actual) {
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return actual == null;
    }

    @Override
    public String mismatchDescription() {
        return String.format("Expected null reference, but got #%d (points to [%s])", System.identityHashCode(actual), actual);
    }
}
