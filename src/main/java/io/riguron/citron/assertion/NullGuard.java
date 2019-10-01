package io.riguron.citron.assertion;

import java.util.Collection;
import java.util.function.Predicate;

public class NullGuard<T, R> implements Assertion<T, R> {

    private final Assertion<T, R> delegate;

    public NullGuard(Assertion<T, R> delegate) {
        this.delegate = delegate;
    }

    @Override
    public R matches(Predicate<T> predicate) {
        return delegate.matches(checkArgument(predicate));
    }

    @Override
    public R is(T expected) {
        return delegate.is(expected);
    }

    @Override
    public R sameWith(T expected) {
        return delegate.sameWith(expected);
    }

    @Override
    public R isNull() {
        return delegate.isNull();
    }

    @Override
    public R isSubclassOf(Class<?> expectedType) {
        return delegate.isSubclassOf(checkArgument(expectedType));
    }

    @Override
    public R isInstanceOf(Class<?> expectedType) {
        return delegate.isInstanceOf(checkArgument(expectedType));
    }

    @Override
    public R isNotNull() {
        return delegate.isNotNull();
    }

    @Override
    public R isAnything() {
        return delegate.isAnything();
    }

    @Override
    public R isNot(T expected) {
        return delegate.isNot(expected);
    }

    @Override
    public R isOneOf(T... expectedElements) {
        return delegate.isOneOf(checkArgument(expectedElements));
    }

    @Override
    public R isOneOf(Collection<? extends T> expectedElements) {
        return delegate.isOneOf(checkArgument(expectedElements));
    }

    @Override
    public R isNotOneOf(T... expectedElements) {
        return delegate.isNotOneOf(checkArgument(expectedElements));
    }

    @Override
    public R isNotOneOf(Collection<? extends T> expectedElements) {
        return delegate.isNotOneOf(checkArgument(expectedElements));
    }

    @Override
    public R equalToEveryOf(T... expectedElements) {
        return delegate.equalToEveryOf(checkArgument(expectedElements));
    }

    @Override
    public R equalToEveryOf(Collection<? extends T> expectedElements) {
        return delegate.equalToEveryOf(checkArgument(expectedElements));
    }

    public <I> I checkArgument(I instance) {
        if (instance == null) {
            throw new IllegalArgumentException("Non-null argument is expected");
        }
        return instance;
    }

}
