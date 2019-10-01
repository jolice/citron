package io.riguron.citron.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubclassMatcherTest extends MatcherTest {
    @Override
    protected List<Matcher<?>> shouldMatch() {
        return Arrays.asList(
                new SubclassMatcher<>(Number.class, 5),
                new SubclassMatcher<>(CharSequence.class, "str")
        );
    }

    @Override
    protected List<Matcher<?>> shouldNotMatch() {
        return Arrays.asList(
                new SubclassMatcher<>(Integer.class, 5),
                new SubclassMatcher<>(Map.class, new ArrayList<>())
        );
    }
}
