package io.riguron.citron.matcher.collection.description;

import java.util.function.Function;

public class OneOfDescription<T> implements Function<T, String> {

    @Override
    public String apply(T t) {
        return String.format("Element [%s] does not reside in the specified collection of elements", t);
    }
}
