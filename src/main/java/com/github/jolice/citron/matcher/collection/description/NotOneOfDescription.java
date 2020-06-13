package com.github.jolice.citron.matcher.collection.description;

import java.util.function.Function;

public class NotOneOfDescription<T> implements Function<T, String> {

    @Override
    public String apply(T t) {
        return String.format("Element [%s] was not expected to be present in the specified collection", t);
    }
}
