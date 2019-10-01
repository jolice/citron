package io.riguron.citron.assertion.recurring;

import io.riguron.citron.assertion.Assertion;
import io.riguron.citron.assertion.chain.ChainingAssertion;
import io.riguron.citron.assertion.chain.Intermediate;
import io.riguron.citron.matcher.Matcher;
import lombok.experimental.Delegate;

public class RecurringAssertion<T> implements Assertion<T, Intermediate<RecurringAssertion<T>>> {

    @Delegate
    private final ChainingAssertion<T, RecurringAssertion<T>> delegate;

    public RecurringAssertion(Assertion<T, Matcher<T>> tMatcherAssertion) {
        this.delegate = new ChainingAssertion<>(tMatcherAssertion, () -> this);
    }


}
