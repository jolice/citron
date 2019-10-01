package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.Matcher;

public class StartsWithMatcher implements Matcher<String> {

    private final String actual;
    private final String prefix;

    public StartsWithMatcher(String actual, String prefix) {
        this.actual = actual;
        this.prefix = prefix;
    }

    @Override
    public boolean evaluate() {
        return actual.startsWith(prefix);
    }

    @Override
    public String mismatchDescription() {
        return String.format("String '%s' does not start with '%s'", actual, prefix);
    }
}
