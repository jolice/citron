package com.github.jolice.citron.matcher;

import java.util.Arrays;
import java.util.List;

public class EqualityMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(new EqualityMatcher<>(1, 1), new EqualityMatcher<>("abc", "abc"),
                new EqualityMatcher<>(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(new EqualityMatcher<>(5, 6), new EqualityMatcher<>("ddd", "eee"),
                new EqualityMatcher<>(Arrays.asList(1, 3, 2), Arrays.asList(1, 2, 3))    );
    }
}
