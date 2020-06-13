package com.github.jolice.citron.matcher.collection;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class AllOfTest {

    @Test
    public void whenAllMatch() {
        AllOf<Integer> allOf = new AllOf<>();
        assertTrue(
                allOf.test(5, Arrays.asList(5, 5, 5, 5)));
    }

    @Test
    public void whenEmptyList() {
        AllOf<Integer> allOf = new AllOf<>();
        assertFalse(
                allOf.test(5, emptyList()));
    }

    @Test
    public void whenOneDiffers() {
        AllOf<Integer> allOf = new AllOf<>();
        assertFalse(
                allOf.test(5, Arrays.asList(5, 6, 5, 5)));
    }
}