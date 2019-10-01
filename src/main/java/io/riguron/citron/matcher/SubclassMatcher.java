package io.riguron.citron.matcher;

public class SubclassMatcher<T> implements Matcher<T> {

    private final Class<?> expected;
    private final T actual;

    public SubclassMatcher(Class<?> expected, T actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return actual != null && !expected.equals(actual.getClass()) && expected.isAssignableFrom(actual.getClass());

    }

    @Override
    public String mismatchDescription() {
        return String.format("Actual object [%s] is not an instance of the subclass of %s", actual, expected);
    }
}
