package com.github.jolice.citron.matcher.collection.description;

import java.util.function.Function;

public class AllOfDescription<T> implements Function<T, String> {

    @Override
    public String apply(T t) {
        return String.format("At least one of the elements of the specified collection does not equal to [%s]", t);
    }
}
