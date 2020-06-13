package com.github.jolice.citron.matcher;

import java.util.Arrays;
import java.util.List;

public class PredicateMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new PredicateMatcher<>(x -> x == 2 + 3, 5),
                new PredicateMatcher<>(x -> x.equals("ab" + "cde"), "abcde"),
                new PredicateMatcher<>(x -> true, "any")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new PredicateMatcher<>(x -> false, "any"),
                new PredicateMatcher<>(x -> x == 8 / 4, 3)
        );
    }
}
