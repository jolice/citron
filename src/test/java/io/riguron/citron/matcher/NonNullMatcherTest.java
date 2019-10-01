package io.riguron.citron.matcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NonNullMatcherTest extends MatcherTest {

    @Override
    protected List<Matcher<?>> shouldMatch() {
        
        return Arrays.asList(new NonNullMatcher<>(5), new NonNullMatcher<>("abc"), new NonNullMatcher<>(new Object()));
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Collections.singletonList(new NonNullMatcher<>(null));
    }
}