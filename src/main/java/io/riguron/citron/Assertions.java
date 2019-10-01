package io.riguron.citron;

import io.riguron.citron.assertion.FunctionAssertion;
import io.riguron.citron.assertion.string.MatcherStringAssertion;
import io.riguron.citron.assertion.string.NullGuardingStringAssertion;
import io.riguron.citron.assertion.string.RecurringStringAssertion;
import io.riguron.citron.assertion.string.StringAssertion;
import io.riguron.citron.assertion.NullGuard;
import io.riguron.citron.matcher.Matcher;
import io.riguron.citron.assertion.evaluate.EvaluatingAssertion;

import io.riguron.citron.assertion.evaluate.EvaluatingStringAssertion;
import io.riguron.citron.assertion.recurring.RecurringAssertion;
import io.riguron.citron.assertion.MatcherProvidingAssertion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("WeakerAccess")
public class Assertions {

    public static RecurringStringAssertion assertThat(String actual) {
        MatcherProvidingAssertion<String> matcherProvidingAssertion = new MatcherProvidingAssertion<>(actual);
        StringAssertion<Matcher<String>> delegate = new EvaluatingStringAssertion(new EvaluatingAssertion<>(matcherProvidingAssertion),
                new MatcherStringAssertion(actual, matcherProvidingAssertion)
        );
        return new RecurringStringAssertion(new NullGuardingStringAssertion<>(new NullGuard<>(delegate), delegate));
    }

    public static FunctionAssertion assertThat(Runnable runnable) {
        return new FunctionAssertion(runnable);
    }

    public static <T> RecurringAssertion<T> assertThat(T actual) {
        return new RecurringAssertion<>(new NullGuard<>(new EvaluatingAssertion<>(new MatcherProvidingAssertion<>(actual))));
    }

}
