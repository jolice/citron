package com.github.jolice.citron.matcher;

import java.util.Collections;
import java.util.List;

public class AnythingMatcherTest extends MatcherTest {

    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Collections.singletonList(new AnythingMatcher<>());
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Collections.emptyList();
    }
}
