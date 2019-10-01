package io.riguron.citron.string;

import io.riguron.citron.matcher.Matcher;

import java.util.function.Function;

public class DefaultStringEquality implements StringEquality<Matcher<String>> {

    private final Function<String, Matcher<String>> matcherProvider;

    public DefaultStringEquality(Function<String, Matcher<String>> matcherProvider) {
        this.matcherProvider = matcherProvider;
    }

    @Override
    public Matcher<String> is(String expected) {
        return matcherProvider.apply(expected);
    }

}
