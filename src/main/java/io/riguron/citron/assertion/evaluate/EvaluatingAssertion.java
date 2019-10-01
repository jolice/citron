package io.riguron.citron.assertion.evaluate;

import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.matcher.MatcherAssertion;
import io.riguron.citron.assertion.Assertion;

import java.util.Collection;
import java.util.function.Predicate;

public class EvaluatingAssertion<T> implements Assertion<T, Matcher<T>> {

    private final Assertion<T, Matcher<T>> delegate;

    public EvaluatingAssertion(Assertion<T, Matcher<T>> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Matcher<T> matches(Predicate<T> predicate) {
        return evaluate(delegate.matches(predicate));
    }

    @Override
    public Matcher<T> is(T expected) {
        return evaluate(delegate.is(expected));
    }

    @Override
    public Matcher<T> sameWith(T expected) {
        return evaluate(delegate.sameWith(expected));
    }

    @Override
    public Matcher<T> isNull() {
        return evaluate(delegate.isNull());
    }

    @Override
    public Matcher<T> isSubclassOf(Class<?> expectedType) {
        return evaluate(delegate.isSubclassOf(expectedType));
    }

    @Override
    public Matcher<T> isInstanceOf(Class<?> expectedType) {
        return evaluate(delegate.isInstanceOf(expectedType));
    }

    @Override
    public Matcher<T> isNotNull() {
        return evaluate(delegate.isNotNull());
    }

    @Override
    public Matcher<T> isAnything() {
        return evaluate(delegate.isAnything());
    }

    @Override
    public Matcher<T> isNot(T expected) {
        return evaluate(delegate.isNot(expected));
    }

    @Override
    public Matcher<T> isOneOf(T... expectedElements) {
        return evaluate(delegate.isOneOf(expectedElements));
    }

    @Override
    public Matcher<T> isOneOf(Collection<? extends T> expectedElements) {
        return evaluate(delegate.isOneOf(expectedElements));
    }

    @Override
    public Matcher<T> isNotOneOf(T... expectedElements) {
        return evaluate(delegate.isNotOneOf(expectedElements));
    }

    @Override
    public Matcher<T> isNotOneOf(Collection<? extends T> expectedElements) {
        return evaluate(delegate.isNotOneOf(expectedElements));
    }

    @Override
    public Matcher<T> equalToEveryOf(T... expectedElements) {
        return evaluate(delegate.equalToEveryOf(expectedElements));
    }

    @Override
    public Matcher<T> equalToEveryOf(Collection<? extends T> expectedElements) {
        return evaluate(delegate.equalToEveryOf(expectedElements));
    }

    public Matcher<T> evaluate(Matcher<T> matcher) {
        return new MatcherAssertion<>(matcher).doAssert();
    }
}
