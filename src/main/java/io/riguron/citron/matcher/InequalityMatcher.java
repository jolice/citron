package io.riguron.citron.matcher;

public class InequalityMatcher<T> implements Matcher<T> {

    private final T expected;
    private final T actual;

    public InequalityMatcher(T expected, T actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return !expected.equals(actual);
    }

    @Override
    public String mismatchDescription() {
        return String.format(
                "Two unequal objects were expected, but got two equal ones: [%s], an expected one is referred by #%d, actual is referred by #%d",
                actual,
                System.identityHashCode(expected),
                System.identityHashCode(actual)
        );
    }
}
