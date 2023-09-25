package com.em.grapes.main.fomanticUI;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import com.em.grapes.main.fomanticUI.Toast;

public class ToastFeatureMatchers {
    /**
     * Custom hamcrest matcher for our Toast class that check value of clazz field
     * @param matcher for clazz field
     * @return new FeatureMatcher that matches on clazz field
     */
    public static FeatureMatcher<Toast, String> clazz(Matcher<String> matcher) {
        return new FeatureMatcher<>(matcher, "clazz", "clazz") {
            @Override
            protected String featureValueOf(Toast actual) {
                return actual.clazz();
            }
        };
    }
}
