package com.github.jolice.citron.assertion.chain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Intermediate<R> {

    private final R reference;

    public R and() {
        return reference;
    }
}
