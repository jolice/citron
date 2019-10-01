package io.riguron.citron.matcher;

import java.util.Arrays;
import java.util.List;

public class IdentityMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        Object left = new Object();
        return Arrays.asList(
                new IdentityMatcher<>(left, left), new IdentityMatcher<>(5, 5), new IdentityMatcher<>(left, left), new IdentityMatcher<>("abc", "abc")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        Object a = new Object();
        Object b = new Object();
        return Arrays.asList(
                new IdentityMatcher<>(666, 666), new IdentityMatcher<>(a, b)
        );
    }
}
