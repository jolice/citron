package com.github.jolice.citron.matcher;

import java.util.Arrays;
import java.util.List;

public class InequalityMatcherTest extends MatcherTest {


    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(new InequalityMatcher<>(5, 6), new InequalityMatcher<>("ddd", "eee"),
                new InequalityMatcher<>(Arrays.asList(1, 3, 2), Arrays.asList(1, 2, 3))    );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(new InequalityMatcher<>(1, 1), new InequalityMatcher<>("abc", "abc"),
                new InequalityMatcher<>(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
    }
}