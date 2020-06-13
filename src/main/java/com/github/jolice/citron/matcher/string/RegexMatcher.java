package com.github.jolice.citron.matcher.string;

import com.github.jolice.citron.matcher.Matcher;

public class RegexMatcher implements Matcher<String> {

    private String regex;
    private String actual;

    public RegexMatcher(String regex, String actual) {
        this.regex = regex;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return actual != null && regex.matches(actual);
    }

    @Override
    public String mismatchDescription() {
        return String.format("String '%s' does not match the regular expression '%s'", actual, regex);
    }
}
