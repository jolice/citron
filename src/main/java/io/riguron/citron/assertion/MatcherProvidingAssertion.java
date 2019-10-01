package io.riguron.citron.assertion;

import io.riguron.citron.matcher.*;
import io.riguron.citron.matcher.collection.AllOf;
import io.riguron.citron.matcher.collection.CollectionMatcher;
import io.riguron.citron.matcher.collection.Inverse;
import io.riguron.citron.matcher.collection.OneOf;
import io.riguron.citron.matcher.collection.description.AllOfDescription;
import io.riguron.citron.matcher.collection.description.NotOneOfDescription;
import io.riguron.citron.matcher.collection.description.OneOfDescription;

import java.util.Collection;
import java.util.function.Predicate;

public class MatcherProvidingAssertion<T> implements Assertion<T, Matcher<T>> {

    private final T actual;

    public MatcherProvidingAssertion(T actual) {
        this.actual = actual;
    }

    @Override
    public Matcher<T> matches(Predicate<T> predicate) {
        return new PredicateMatcher<>(predicate, actual);
    }

    @Override
    public Matcher<T> is(T expected) {
        return new EqualityMatcher<>(expected, actual);
    }

    @Override
    public Matcher<T> sameWith(T expected) {
        return new IdentityMatcher<>(expected, actual);
    }

    @Override
    public Matcher<T> isNull() {
        return new NullMatcher<>(actual);
    }

    @Override
    public Matcher<T> isSubclassOf(Class<?> expectedType) {
        return new SubclassMatcher<>(expectedType, actual);
    }

    @Override
    public Matcher<T> isInstanceOf(Class<?> expectedType) {
        return new ClassMatcher<>(actual, expectedType);
    }

    @Override
    public Matcher<T> isNotNull() {
        return new NonNullMatcher<>(actual);
    }

    @Override
    public Matcher<T> isAnything() {
        return new AnythingMatcher<>();
    }

    @Override
    public Matcher<T> isNot(T expected) {
        return new InequalityMatcher<>(expected, actual);
    }

    @Override
    public Matcher<T> isOneOf(T... expectedElements) {
        return new CollectionMatcher<>(new OneOf<>(), expectedElements, new OneOfDescription<>(), actual);
    }

    @Override
    public Matcher<T> isOneOf(Collection<? extends T> expectedElements) {
        return new CollectionMatcher<>(new OneOf<>(), expectedElements, new OneOfDescription<>(), actual);
    }

    @Override
    public Matcher<T> isNotOneOf(T... expectedElements) {
        return new CollectionMatcher<>(new Inverse<>(new OneOf<>()), expectedElements, new NotOneOfDescription<>(), actual);
    }

    @Override
    public Matcher<T> isNotOneOf(Collection<? extends T> expectedElements) {
        return new CollectionMatcher<>(new Inverse<>(new OneOf<>()), expectedElements, new NotOneOfDescription<>(), actual);
    }

    @Override
    public Matcher<T> equalToEveryOf(T... expectedElements) {
        return new CollectionMatcher<>(new AllOf<>(), expectedElements, new AllOfDescription<>(), actual);
    }

    @Override
    public Matcher<T> equalToEveryOf(Collection<? extends T> expectedElements) {
        return new CollectionMatcher<>(new AllOf<>(), expectedElements, new AllOfDescription<>(), actual);
    }

}
