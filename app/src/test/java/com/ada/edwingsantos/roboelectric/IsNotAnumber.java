package com.ada.edwingsantos.roboelectric;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by edwingsantos on 5/11/16.
 */
public class IsNotAnumber extends TypeSafeMatcher<Double> {
    @Override
    protected boolean matchesSafely(Double item) {
        return item.isNaN();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("not a numbers");
    }
    @Factory
    public static <E> Matcher<Double> notANumber(){
        return new IsNotAnumber();
    }


}
