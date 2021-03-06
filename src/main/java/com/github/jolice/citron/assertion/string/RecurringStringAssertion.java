package com.github.jolice.citron.assertion.string;

import com.github.jolice.citron.matcher.Matcher;
import com.github.jolice.citron.string.NavigatingStringEquality;
import com.github.jolice.citron.string.StringEquality;
import com.github.jolice.citron.assertion.chain.ChainingAssertion;
import com.github.jolice.citron.assertion.chain.Intermediate;

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
    public Intermediate<RecurringStringAssertion> isIn(String... expectedElements) {
        return chainingAssertion.isIn(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isIn(Collection<? extends String> expectedElements) {
        return chainingAssertion.isIn(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNotIn(String... expectedElements) {
        return chainingAssertion.isNotIn(expectedElements);
    }

    @Override
    public Intermediate<RecurringStringAssertion> isNotIn(Collection<? extends String> expectedElements) {
        return chainingAssertion.isNotIn(expectedElements);
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
