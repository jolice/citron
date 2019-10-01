package io.riguron.citron.assertion.string;

import io.riguron.citron.assertion.NullGuard;
import io.riguron.citron.string.StringEquality;
import lombok.experimental.Delegate;

public class NullGuardingStringAssertion<R> implements StringAssertion<R> {

    @Delegate
    private final NullGuard<String, R> parent;
    private final StringAssertion<R> delegate;

    public NullGuardingStringAssertion(NullGuard<String, R> parent, StringAssertion<R> delegate) {
        this.parent = parent;
        this.delegate = delegate;
    }

    @Override
    public StringEquality<R> ignoringCase() {
        return delegate.ignoringCase();
    }

    @Override
    public StringEquality<R> ignoringWhitespace() {
        return delegate.ignoringWhitespace();
    }

    @Override
    public R matches(String regularExpression) {
        return delegate.matches(parent.checkArgument(regularExpression));
    }

    @Override
    public R contains(String expected) {
        return delegate.contains(parent.checkArgument(expected));
    }

    @Override
    public R endsWith(String expected) {
        return delegate.endsWith(parent.checkArgument(expected));
    }

    @Override
    public R startsWith(String expected) {
        return delegate.startsWith(parent.checkArgument(expected));
    }
}
