package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.matcher.MatcherTest;

import java.util.Arrays;
import java.util.List;

public class EndsWithMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new EndsWithMatcher("def", "f"),
                new EndsWithMatcher("def", "ef"),
                new EndsWithMatcher("def", "def"),
                new EndsWithMatcher("ccc", "cc")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new EndsWithMatcher("const", "s"),
                new EndsWithMatcher("const", "ns"),
                new EndsWithMatcher("const", "cons")
        );
    }
}
