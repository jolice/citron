package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.Matcher;

public class ContainsMatcher implements Matcher<String> {

    private final String part;
    private final String actual;

    public ContainsMatcher(String part, String actual) {
        this.part = part;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return actual.contains(part);
    }

    @Override
    public String mismatchDescription() {
        return String.format("String '%s' does not contain '%s'", actual, part);
    }
}
