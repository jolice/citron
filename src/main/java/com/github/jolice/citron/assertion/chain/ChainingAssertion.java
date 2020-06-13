package com.github.jolice.citron.assertion.chain;

import com.github.jolice.citron.assertion.Assertion;
import com.github.jolice.citron.matcher.Matcher;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ChainingAssertion<T, R> implements Assertion<T, Intermediate<R>> {

    private final Assertion<T, Matcher<T>> matcherAssertion;
    private final Supplier<R> instanceProvider;

    public ChainingAssertion(Assertion<T, Matcher<T>> matcherAssertion, Supplier<R> instanceProvider) {
        this.matcherAssertion = matcherAssertion;
        this.instanceProvider = instanceProvider;
    }

    @Override
    public Intermediate<R> matches(Predicate<T> predicate) {
        return intermediate(() -> matcherAssertion.matches(predicate));
    }

    @Override
    public Intermediate<R> is(T expected) {
        return intermediate(() -> matcherAssertion.is(expected));
    }

    @Override
    public Intermediate<R> sameWith(T expected) {
        return intermediate(() -> matcherAssertion.sameWith(expected));
    }

    @Override
    public Intermediate<R> isNull() {
        return intermediate(matcherAssertion::isNull);
    }

    @Override
    public Intermediate<R> isSubclassOf(Class<?> expectedType) {
        return intermediate(() -> matcherAssertion.isSubclassOf(expectedType));
    }

    @Override
    public Intermediate<R> isInstanceOf(Class<?> expectedType) {
        return intermediate(() -> matcherAssertion.isInstanceOf(expectedType));
    }

    @Override
    public Intermediate<R> isNotNull() {
        return intermediate(matcherAssertion::isNotNull);
    }

    @Override
    public Intermediate<R> isAnything() {
        return intermediate(matcherAssertion::isAnything);
    }

    @Override
    public Intermediate<R> isNot(T expected) {
        return intermediate(() -> matcherAssertion.isNot(expected));
    }

    @Override
    public Intermediate<R> isIn(T... expectedElements) {
        return intermediate(() -> matcherAssertion.isIn(expectedElements));
    }

    @Override
    public Intermediate<R> isIn(Collection<? extends T> expectedElements) {
        return intermediate(() -> matcherAssertion.isIn(expectedElements));
    }

    @Override
    public Intermediate<R> isNotIn(T... expectedElements) {
        return intermediate(() -> matcherAssertion.isNotIn(expectedElements));
    }

    @Override
    public Intermediate<R> isNotIn(Collection<? extends T> expectedElements) {
        return intermediate(() -> matcherAssertion.isNotIn(expectedElements));
    }

    @Override
    public Intermediate<R> equalToEveryOf(T... expectedElements) {
        return intermediate(() -> matcherAssertion.equalToEveryOf(expectedElements));
    }

    @Override
    public Intermediate<R> equalToEveryOf(Collection<? extends T> expectedElements) {
        return intermediate(() -> matcherAssertion.equalToEveryOf(expectedElements));
    }

    private Intermediate<R> intermediate(Runnable runnable) {
        runnable.run();
        return new Intermediate<>(instanceProvider.get());
    }


}
