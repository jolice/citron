package io.riguron.citron.assertion;

import java.util.Collection;
import java.util.function.Predicate;

public interface Assertion<T, R> {

    R matches(Predicate<T> predicate);

    R is(T expected);

    R sameWith(T expected);

    R isNull();

    R isSubclassOf(Class<?> expectedType);

    R isInstanceOf(Class<?> expectedType);

    R isNotNull();

    R isAnything();

    R isNot(T expected);

    R isOneOf(T... expectedElements);

    R isOneOf(Collection<? extends T> expectedElements);

    R isNotOneOf(T... expectedElements);

    R isNotOneOf(Collection<? extends T> expectedElements);

    R equalToEveryOf(T... expectedElements);

    R equalToEveryOf(Collection<? extends T> expectedElements);
}
