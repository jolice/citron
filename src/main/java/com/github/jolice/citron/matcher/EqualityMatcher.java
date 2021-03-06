package com.github.jolice.citron.matcher;

public class EqualityMatcher<T> extends BiMatcher<T> {

    public EqualityMatcher(T expected, T actual) {
        super(expected, actual, Object::equals);
    }
}
