package com.github.jolice.citron.matcher.string;

import com.github.jolice.citron.matcher.BiMatcher;

public class IgnoreCaseMatcher extends BiMatcher<String> {

    public IgnoreCaseMatcher(String expected, String actual) {
        super(expected, actual, String::equalsIgnoreCase);
    }
}
