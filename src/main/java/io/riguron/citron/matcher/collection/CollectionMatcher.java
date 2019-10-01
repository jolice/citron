package io.riguron.citron.matcher.collection;

import io.riguron.citron.matcher.Matcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class CollectionMatcher<T> implements Matcher<T> {

    private final BiPredicate<T, Collection<? extends T>> predicate;
    private final Collection<? extends T> collection;
    private final Function<T, String> descriptionProvider;
    private final T actual;

    public CollectionMatcher(BiPredicate<T, Collection<? extends T>> predicate, T[] elements, Function<T, String> descriptionProvider, T actual) {
        this.predicate = predicate;
        this.collection = Arrays.asList(elements);
        this.descriptionProvider = descriptionProvider;
        this.actual = actual;
    }

    public CollectionMatcher(BiPredicate<T, Collection<? extends T>> predicate, Collection<? extends T> collection, Function<T, String> descriptionProvider, T actual) {
        this.predicate = predicate;
        this.collection = collection;
        this.descriptionProvider = descriptionProvider;
        this.actual = actual;
    }

    @Override
    public boolean evaluate() {
        return predicate.test(actual, collection);
    }

    @Override
    public String mismatchDescription() {
        return descriptionProvider.apply(actual);
    }
}
