package io.riguron.citron;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;

import static io.riguron.citron.Assertions.assertThat;

public class AssertionsTest {


    @Test
    public void testString() {
        int result = 2 + 2;
        assertThat(result)
                .isNotNull()
                .and()
                .is(4)
                .and()
                .isIn(3, 4, 5);
    }

    @Test
    public void testForObject() {

        assertThat(205)
                .isAnything()
                .and()
                .is(205)
                .and()
                .isNotNull()
                .and()
                .isIn(6, 205, 2)
                .and()
                .isIn(Arrays.asList(6, 205, 5))
                .and()
                .matches(x -> x == 200 + 5)
                .and()
                .equalToEveryOf(205, 205, 205)
                .and()
                .isNotIn(206, 204, 203)
                .and()
                .isInstanceOf(Integer.class)
                .and()
                .isSubclassOf(Number.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNullArgument() {
        assertThat(100)
                .matches(null)
                .and()
                .is(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNullArgumentStringStartsWith() {
        assertThat("abc")
                .startsWith(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNullArgumentStringMatches() {
        assertThat("abc")
                .matches((Predicate<String>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNullArgumentStartsWithAfterIntermediate() {
        assertThat("abc")
                .ignoringCase().is("aBc")
                .and()
                .startsWith(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNullArgumentMatchesAfterIntermediate() {
        assertThat("abc")
                .ignoringCase().is("aBc")
                .and()
                .matches((Predicate<String>) null);
    }

    @Test
    public void testForString() {


        assertThat("abcde")
                .isIn("abcde", "abcd", "ab")
                .and()
                .is("abcde")
                .and()
                .isNotNull()
                .and()
                .matches(x -> x.equals("ab" + "cd" + "e"))
                .and()
                .sameWith("abcde") // String pool
                .and()
                .startsWith("a")
                .and()
                .endsWith("e")
                .and()
                .contains("bcd")
                .and()
                .ignoringCase().is("aBcDe")
                .and()
                .ignoringWhitespace().is("a b c d  e")
                .and()
                .isAnything()
                .and()
                .isNotIn("a", "b", "c", "d")
                .and()
                .isInstanceOf(String.class)
                .and()
                .isSubclassOf(CharSequence.class)
                .and();

    }
}
