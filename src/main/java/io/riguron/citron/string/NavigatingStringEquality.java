package io.riguron.citron.string;

import io.riguron.citron.assertion.string.RecurringStringAssertion;
import io.riguron.citron.assertion.chain.Intermediate;

public class NavigatingStringEquality implements StringEquality<Intermediate<RecurringStringAssertion>> {

    private final StringEquality<?> delegate;
    private final Intermediate<RecurringStringAssertion> intermediate;

    public NavigatingStringEquality(StringEquality<?> delegate, Intermediate<RecurringStringAssertion> intermediate) {
        this.delegate = delegate;
        this.intermediate = intermediate;
    }

    @Override
    public Intermediate<RecurringStringAssertion> is(String string) {
        delegate.is(string);
        return intermediate;
    }
}
