package com.github.jolice.citron.matcher;

public class MatcherAssertion<T> {

    private final Matcher<T> matcher;

    public MatcherAssertion(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    public Matcher<T> doAssert() {
        if (!matcher.evaluate()) {
            throw new AssertionError(matcher.mismatchDescription());
        }
        return matcher;
    }
}
