package com.github.jolice.citron.matcher.string;

import com.github.jolice.citron.matcher.BiMatcher;

public class IgnoreWhitespaceMatcher extends BiMatcher<String> {

    public IgnoreWhitespaceMatcher(String expected, String actual) {
        super(expected, actual, (s, s2) -> expected.replaceAll("\\s", "").equals(actual));
    }


}
