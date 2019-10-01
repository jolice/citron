package io.riguron.citron.matcher.string;

import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.matcher.MatcherTest;

import java.util.Arrays;
import java.util.List;

public class ContainsMatcherTest extends MatcherTest {

    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new ContainsMatcher("df", "sdf"),
                new ContainsMatcher("I", "JNDI")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new ContainsMatcher("D", "sdf"),
                new ContainsMatcher("x", "vector")
        );
    }
}
