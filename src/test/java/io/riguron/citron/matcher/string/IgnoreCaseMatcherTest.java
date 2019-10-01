package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.matcher.MatcherTest;

import java.util.Arrays;
import java.util.List;

public class IgnoreCaseMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new IgnoreCaseMatcher("exp", "eXp"),
                new IgnoreCaseMatcher("exp", "eXP"),
                new IgnoreCaseMatcher("exp", "EXP"),
                new IgnoreCaseMatcher("EXP", "exp"),
                new IgnoreCaseMatcher("ExP", "exP")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new IgnoreCaseMatcher("a", "aa"),
                new IgnoreCaseMatcher("bbb", "BBa")
        );
    }
}
