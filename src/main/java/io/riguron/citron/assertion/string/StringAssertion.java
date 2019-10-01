package io.riguron.citron.assertion.string;

import io.riguron.citron.string.StringEquality;
import io.riguron.citron.assertion.Assertion;

public interface StringAssertion<R> extends Assertion<String, R> {

    StringEquality<R> ignoringCase();

    StringEquality<R> ignoringWhitespace();

    R matches(String regularExpression);

    R contains(String expected);

    R endsWith(String expected);

    R startsWith(String expected);
}
