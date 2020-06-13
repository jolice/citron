package com.github.jolice.citron.matcher.collection;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CollectionMatcherTest {

    @Test
    public void basicCase() {
        CollectionMatcher<Integer> collectionMatcher =
                new CollectionMatcher<>(
                        (integer, integers) -> integers.contains(integer),
                        new Integer[]{1, 2, 3},
                        integer -> "absent- " + integer,
                        5
                );

        assertFalse(collectionMatcher.evaluate());
    }

}