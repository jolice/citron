package com.github.jolice.citron.matcher.string;

import com.github.jolice.citron.matcher.Matcher;
import com.github.jolice.citron.matcher.MatcherTest;

import java.util.Arrays;
import java.util.List;

public class IgnoreWhitespaceMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new IgnoreWhitespaceMatcher("a b c", "abc"),
                new IgnoreWhitespaceMatcher("a   b    c ", "abc"),
                new IgnoreWhitespaceMatcher("a  bc  ", "abc")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new IgnoreWhitespaceMatcher("abc", "a b c"),
                new IgnoreWhitespaceMatcher("d ef ", "dfe")
        );
    }
}
