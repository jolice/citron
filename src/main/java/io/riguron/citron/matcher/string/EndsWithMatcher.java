package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.Matcher;

public class EndsWithMatcher implements Matcher<String> {

    private final String actual;
    private final String suffix;

    public EndsWithMatcher(String actual, String suffix) {
        this.actual = actual;
        this.suffix = suffix;
    }

    @Override
    public boolean evaluate() {
        return actual.endsWith(suffix);
    }

    @Override
    public String mismatchDescription() {
        return String.format("String '%s' does not end with '%s'", actual, suffix);
    }
}
