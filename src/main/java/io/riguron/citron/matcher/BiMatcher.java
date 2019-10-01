package io.riguron.citron.matcher;

import java.util.function.BiPredicate;

public class BiMatcher<T> implements Matcher<T> {

    private final T expected;
    private final T actual;
    private final BiPredicate<T, T> predicate;

    public BiMatcher(T expected, T actual, BiPredicate<T, T> predicate) {
        this.expected = expected;
        this.actual = actual;
        this.predicate = predicate;
    }

    @Override
    public boolean evaluate() {
        return predicate.test(expected, actual);
    }

    @Override
    public String mismatchDescription() {
        return String.format("Expected %s, but got %s", expected, actual);
    }
}
