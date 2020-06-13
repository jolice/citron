package com.github.jolice.citron.matcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NullMatcherTest extends MatcherTest {

    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Collections.singletonList(new NullMatcher<>(null));

    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(new NullMatcher<>(5), new NullMatcher<>("abc"), new NullMatcher<>(new Object()));
    }

}