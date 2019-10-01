package io.riguron.citron.matcher;

public class AnythingMatcher<T> implements Matcher<T> {

    @Override
    public boolean evaluate() {
        return true;
    }

    @Override
    public String mismatchDescription() {
        throw new UnsupportedOperationException();
    }
}
