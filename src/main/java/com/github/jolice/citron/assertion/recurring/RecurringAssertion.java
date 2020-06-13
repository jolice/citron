package com.github.jolice.citron.assertion.recurring;

import com.github.jolice.citron.assertion.Assertion;
import com.github.jolice.citron.assertion.chain.ChainingAssertion;
import com.github.jolice.citron.assertion.chain.Intermediate;
import com.github.jolice.citron.matcher.Matcher;
import lombok.experimental.Delegate;

public class RecurringAssertion<T> implements Assertion<T, Intermediate<RecurringAssertion<T>>> {

    @Delegate
    private final ChainingAssertion<T, RecurringAssertion<T>> delegate;

    public RecurringAssertion(Assertion<T, Matcher<T>> tMatcherAssertion) {
        this.delegate = new ChainingAssertion<>(tMatcherAssertion, () -> this);
    }


}
