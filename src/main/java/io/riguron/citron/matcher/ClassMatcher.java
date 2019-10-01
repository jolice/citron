package io.riguron.citron.matcher;

public class ClassMatcher<T> implements Matcher<T> {

    private T actual;
    private Class<?> type;

    public ClassMatcher(T actual, Class<?> type) {
        this.actual = actual;
        this.type = type;
    }

    @Override
    public boolean evaluate() {
        return actual != null && actual.getClass().equals(type);
    }

    @Override
    public String mismatchDescription() {
        return String.format("Actual object [%s] is not a direct instance of %s", actual, type);
    }
}
