package com.github.jolice.citron.string;

import com.github.jolice.citron.matcher.Matcher;
import com.github.jolice.citron.matcher.MatcherAssertion;

public class EvaluatingStringEquality implements StringEquality<Matcher<String>> {

    private StringEquality<Matcher<String>> stringEquality;

    public EvaluatingStringEquality(StringEquality<Matcher<String>> stringEquality) {
        this.stringEquality = stringEquality;
    }

    @Override
    public Matcher<String> is(String string) {
        return new MatcherAssertion<>(stringEquality.is(string)).doAssert();
    }
}
