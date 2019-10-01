package io.riguron.citron;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.riguron.citron.Assertions.assertThat;

public class FunctionAssertionTest {

    @Test
    public void whenNormally() {
        assertThat(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add(i);
                if (list.get(i) != i) {
                    throw new IllegalArgumentException();
                }
            }
        }).completesNormally();
    }

    @Test
    public void whenFails() {
        assertThat(() -> {
            throw new IllegalStateException();
        }).doesThrow(IllegalStateException.class);
    }
}
