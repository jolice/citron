package com.github.jolice.citron.matcher.string;

import com.github.jolice.citron.matcher.Matcher;
import com.github.jolice.citron.matcher.MatcherTest;

import java.util.Arrays;
import java.util.List;

public class StartsWithMatcherTest extends MatcherTest {

    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new StartsWithMatcher("def", "d"),
                new StartsWithMatcher("def", "de"),
                new StartsWithMatcher("def", "def"),
                new StartsWithMatcher("ccc", "cc")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new StartsWithMatcher("const", "co1"),
                new StartsWithMatcher("const", "ns"),
                new StartsWithMatcher("const", "tst")
        );
    }
}
