package io.riguron.citron.matcher.collection;

import java.util.Collection;
import java.util.function.BiPredicate;

public class AllOf<T> implements BiPredicate<T, Collection<? extends T>> {

    @Override
    public boolean test(T t, Collection<? extends T> ts) {
        if (ts.isEmpty()) {
            return false;
        } else {
            for (T i : ts) {
                if (!i.equals(t)) {
                    return false;
                }
            }
            return true;
        }
    }
}
