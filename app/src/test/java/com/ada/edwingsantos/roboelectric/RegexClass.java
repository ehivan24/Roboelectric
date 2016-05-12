package com.ada.edwingsantos.roboelectric;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by edwingsantos on 5/11/16.
 */
public class RegexClass extends TypeSafeMatcher<String> {
    private final String regex;

    public RegexClass(String regex){
        this.regex = regex;
    }


    @Override
    protected boolean matchesSafely(String item) {
        return item.matches(regex);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Matches Regex = `" +regex +"`");
    }

    @Factory
    public static RegexClass matchesRegex(String regex){
        return new RegexClass(regex);
    }
}

/*
http://www.peterfriese.de/android-testing-with-robolectric/
http://eclipsesource.com/blogs/2013/01/21/10-tips-for-using-the-eclipse-memory-analyzer/

http://code.tutsplus.com/tutorials/dependency-injection-on-android-with-roboguice--cms-24827

https://www.lynda.com/Numpy-tutorials/Introduction-Data-Analysis-Python/419162-2.html

 Watch this.
 https://www.youtube.com/watch?v=UEklodQTJZY&index=14&list=PLgJYN3j_khq7hv_XrDw4VglYziRAWdHUR

 */