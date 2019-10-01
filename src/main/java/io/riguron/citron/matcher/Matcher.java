package io.riguron.citron.matcher;

public interface Matcher<T> {

    boolean evaluate();

    String mismatchDescription();

}
