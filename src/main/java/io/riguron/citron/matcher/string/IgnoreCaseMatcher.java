package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.BiMatcher;

public class IgnoreCaseMatcher extends BiMatcher<String> {

    public IgnoreCaseMatcher(String expected, String actual) {
        super(expected, actual, String::equalsIgnoreCase);
    }
}
