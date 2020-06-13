package com.github.jolice.citron.string;

import com.github.jolice.citron.assertion.chain.Intermediate;
import com.github.jolice.citron.assertion.string.RecurringStringAssertion;

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
