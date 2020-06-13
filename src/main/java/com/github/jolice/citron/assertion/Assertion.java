package com.github.jolice.citron.assertion;

import java.util.Collection;
import java.util.function.Predicate;

public interface Assertion<T, R> {

    R matches(Predicate<T> predicate);

    R is(T expected);

    R isNot(T expected);

    R sameWith(T expected);

    R isNull();

    R isNotNull();

    R isSubclassOf(Class<?> expectedType);

    R isInstanceOf(Class<?> expectedType);


    R isAnything();


    R isIn(T... expectedElements);

    R isIn(Collection<? extends T> expectedElements);

    R isNotIn(T... expectedElements);

    R isNotIn(Collection<? extends T> expectedElements);

    R equalToEveryOf(T... expectedElements);

    R equalToEveryOf(Collection<? extends T> expectedElements);
}
