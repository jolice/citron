package io.riguron.citron.matcher.collection;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class OneOfTest {
    @Test
    public void whenExists() {
       assertTrue(  new OneOf<>().test(1, Arrays.asList(2, 3, 1)));
    }

    @Test
    public void whenEmptyList() {
       assertFalse(new OneOf<>().test(1, emptyList()));
    }

    @Test
    public void whenAbsent() {
        assertFalse(new OneOf<>().test(1, Arrays.asList(2, 3, 4)));
    }
}