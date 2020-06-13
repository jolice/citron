package com.github.jolice.citron.assertion.string;

import com.github.jolice.citron.assertion.Assertion;
import com.github.jolice.citron.string.StringEquality;

public interface StringAssertion<R> extends Assertion<String, R> {

    StringEquality<R> ignoringCase();

    StringEquality<R> ignoringWhitespace();

    R matches(String regularExpression);

    R contains(String expected);

    R endsWith(String expected);

    R startsWith(String expected);
}
