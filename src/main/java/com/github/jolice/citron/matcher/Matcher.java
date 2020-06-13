package com.github.jolice.citron.matcher;

public interface Matcher<T> {

    boolean evaluate();

    String mismatchDescription();

}
