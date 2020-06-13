package com.github.jolice.citron.assertion.string;

import com.github.jolice.citron.assertion.Assertion;
import com.github.jolice.citron.matcher.Matcher;
import com.github.jolice.citron.matcher.string.*;
import com.github.jolice.citron.string.DefaultStringEquality;
import com.github.jolice.citron.string.StringEquality;
import lombok.experimental.Delegate;

public class MatcherStringAssertion implements StringAssertion<Matcher<String>> {

    @Delegate
    private final Assertion<String, Matcher<String>> delegate;
    private final String actual;

    public MatcherStringAssertion(String actual, Assertion<String, Matcher<String>> delegate) {
        this.actual = actual;
        this.delegate = delegate;
    }

    @Override
    public StringEquality<Matcher<String>> ignoringCase() {
        return new DefaultStringEquality(s -> new IgnoreCaseMatcher(s, actual));
    }

    @Override
    public StringEquality<Matcher<String>> ignoringWhitespace() {
        return new DefaultStringEquality(s -> new IgnoreWhitespaceMatcher(s, actual));
    }

    @Override
    public Matcher<String> matches(String regularExpression) {
        return new RegexMatcher(regularExpression, actual);
    }

    @Override
    public Matcher<String> contains(String expected) {
        return new ContainsMatcher(expected, actual);
    }

    @Override
    public Matcher<String> endsWith(String suffix) {
        return new EndsWithMatcher(actual, suffix);
    }

    @Override
    public Matcher<String> startsWith(String prefix) {
        return new StartsWithMatcher(actual, prefix);
    }


}
