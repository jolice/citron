package io.riguron.citron.assertion.evaluate;

import io.riguron.citron.assertion.string.StringAssertion;
import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.string.EvaluatingStringEquality;
import io.riguron.citron.string.StringEquality;
import lombok.experimental.Delegate;

public class EvaluatingStringAssertion implements StringAssertion<Matcher<String>> {

    @Delegate
    private final EvaluatingAssertion<String> delegate;
    private final StringAssertion<Matcher<String>> original;

    public EvaluatingStringAssertion(EvaluatingAssertion<String> delegate, StringAssertion<Matcher<String>> original) {
        this.delegate = delegate;
        this.original = original;
    }

    @Override
    public StringEquality<Matcher<String>> ignoringCase() {
        return new EvaluatingStringEquality(original.ignoringCase());
    }

    @Override
    public StringEquality<Matcher<String>> ignoringWhitespace() {
        return new EvaluatingStringEquality(original.ignoringWhitespace());
    }

    @Override
    public Matcher<String> matches(String regularExpression) {
        return delegate.evaluate(original.matches(regularExpression));
    }

    @Override
    public Matcher<String> contains(String expected) {
        return delegate.evaluate(original.contains(expected));
    }

    @Override
    public Matcher<String> endsWith(String expected) {
        return delegate.evaluate(original.endsWith(expected));
    }

    @Override
    public Matcher<String> startsWith(String expected) {
        return delegate.evaluate(original.startsWith(expected));
    }




}
