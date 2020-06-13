package com.github.jolice.citron.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(new ClassMatcher<>("abc", String.class), new ClassMatcher<>(
                1, Integer.class
        ), new ClassMatcher<>(new ArrayList<>(), ArrayList.class));
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(new ClassMatcher<>("abc", Integer.class), new ClassMatcher<>(String.class, String.class));
    }
}
