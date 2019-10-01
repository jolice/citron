package io.riguron.citron.assertion.string;

import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.string.NavigatingStringEquality;
import io.riguron.citron.string.StringEquality;
import io.riguron.citron.assertion.chain.ChainingAssertion;
import io.riguron.citron.assertion.chain.Intermediate;

import java.util.Collection;
import java.util.function.Predicate;

public class RecurringStringAssertion implements StringAssertion<Intermediate<RecurringStringAssertion>> {

    private ChainingAssertion<String, RecurringStringAssertion> chainingAssertion;
    private StringAssertion<Matcher<String>> delegate;

    public RecurringStringAssertion(StringAssertion<Matcher<String>> delegate) {
        this.chainingAssertion = new ChainingAssertion<>(delegate, () -> this);
        this.delegate = delegate;
    }

    @Override
    public StringEquality<Intermediate<RecurringStringAssertion>> ignoringCase() {
        return new NavigatingStringEquality(delegate.ignoringCase(), new Intermediate<>(this));

    }

    @Override
    public  StringEquality<Intermediate<RecurringStringAssertion>> ignoringWhitespace() {
        return new NavigatingStringEquality(delegate.ignoringWhitespace(), new Intermediate<>(this));
    }

    @Override
    public Intermediate<RecurringStringAssertion> matches(String regularExpression) {
        delegate.matches(regularExpression);
        return new Intermediate<>(this);
    }

    @Override
    public Intermediate<RecurringStringAssertion> contains(String expected) {
        delegate.contains(expected);
        return new Intermediate<>(this);
    }

    @Override
    public Intermediate<RecurringStringAssertion> endsWith(String expected) {
        delegate.endsWith(expected);
        return new Intermediate<>(this);
    }

    @Override
    public Intermediate<RecurringStringAssertion> startsWith(String expected) {
        delegate.startsWith(expected);
        return new Intermediate<>(this);
    }

    @Override
    public Intermediate<RecurringStringAssertion> matches(Predicate<String> predicate) {
        return chainingAssertion.matches(predicate);
    }

    @Override
    public Intermediate<RecurringStringAssertion> is(String expected) {
        return chainingAssertion.is(expected);
    }

    @Override
    public Intermediate<RecurringStringAssertion> sameWith(String expected) {
        return chainingAssertion.sameWith(expected);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNull() {
        return chainingAssertion.isNull();
    }

    @Override
    public Intermediate<RecurringStringAssertion> isSubclassOf(Class<?> expectedType) {
        return chainingAssertion.isSubclassOf(expectedType);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isInstanceOf(Class<?> expectedType) {
        return chainingAssertion.isInstanceOf(expectedType);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNotNull() {
        return chainingAssertion.isNotNull();
    }

    @Override
    public Intermediate<RecurringStringAssertion> isAnything() {
        return chainingAssertion.isAnything();
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNot(String expected) {
        return chainingAssertion.isNot(expected);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isOneOf(String... expectedElements) {
        return chainingAssertion.isOneOf(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isOneOf(Collection<? extends String> expectedElements) {
        return chainingAssertion.isOneOf(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNotOneOf(String... expectedElements) {
        return chainingAssertion.isNotOneOf(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNotOneOf(Collection<? extends String> expectedElements) {
        return chainingAssertion.isNotOneOf(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> equalToEveryOf(String... expectedElements) {
        return chainingAssertion.equalToEveryOf(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> equalToEveryOf(Collection<? extends String> expectedElements) {
        return chainingAssertion.equalToEveryOf(expectedElements);
    }
}
