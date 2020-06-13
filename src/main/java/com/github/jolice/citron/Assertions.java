package com.github.jolice.citron;

import com.github.jolice.citron.assertion.FunctionAssertion;
import com.github.jolice.citron.assertion.MatcherProvidingAssertion;
import com.github.jolice.citron.assertion.NullGuard;
import com.github.jolice.citron.assertion.evaluate.EvaluatingAssertion;
import com.github.jolice.citron.assertion.evaluate.EvaluatingStringAssertion;
import com.github.jolice.citron.assertion.recurring.RecurringAssertion;
import com.github.jolice.citron.assertion.string.MatcherStringAssertion;
import com.github.jolice.citron.assertion.string.NullGuardingStringAssertion;
import com.github.jolice.citron.assertion.string.RecurringStringAssertion;
import com.github.jolice.citron.assertion.string.StringAssertion;
import com.github.jolice.citron.matcher.Matcher;

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
