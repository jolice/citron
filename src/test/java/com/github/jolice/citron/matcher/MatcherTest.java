package com.github.jolice.citron.matcher;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public abstract class MatcherTest {

    @Test
    public void match() {
        testAll(shouldMatch(), true);
    }

    @Test
    public void doesNotMatch() {
        testAll(shouldNotMatch(), false);
    }

    protected abstract List<Matcher<?>> shouldMatch();

    protected abstract List<Matcher<?>> shouldNotMatch();

    private void testAll(List<Matcher<?>> matchers, boolean expectedResult) {
        for (Matcher<?> matcher : matchers) {
            boolean result = matcher.evaluate();
            if (result && (!AnythingMatcher.class.equals(matcher.getClass()))) {
                matcher.mismatchDescription();
            }
            assertEquals(result, expectedResult);
        }
    }

}
