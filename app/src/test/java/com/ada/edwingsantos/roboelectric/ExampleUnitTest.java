package com.ada.edwingsantos.roboelectric;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.TestCase;

import org.hamcrest.Matchers;
import org.hamcrest.core.AnyOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;
import static org.fest.assertions.api.ANDROID.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;







/**
 * There are four packages for UnitTesting.
 *  Hamcrest
 *  Fest
 *  Roboelectric
 *  Mockito
 *
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)
public class ExampleUnitTest extends TestCase{

    private MainActivity activity;
    Button downloadBtn;
    TextView nameView;
    EditText editTextURL;

    @Before
    public void setUp()throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);

        downloadBtn = (Button) activity.findViewById(R.id.btn_download);
        nameView = (TextView) activity.findViewById(R.id.text_view);
        editTextURL = (EditText) activity.findViewById(R.id.edit_text_download);
    }

    @Test
    public void main_create_test(){
        assertTrue(Robolectric.buildActivity(MainActivity.class).create().get() != null);
    }

    @Test
    public void null_views_test(){
        assertNotNull(downloadBtn);
        assertNotNull(nameView);
        assertNotNull(editTextURL);
    }

    @Test
    public void when_downloads_starts_controls_disabled(){
        assertTrue(activity.downloadBtn.isEnabled());
        assertTrue(activity.nameView.isEnabled());
        assertTrue(activity.editTextURL.isEnabled());
    }

    @Test
    public void btn_click(){
        activity.downloadBtn.performClick();
        assertFalse(activity.downloadBtn.isEnabled());
        assertFalse(activity.editTextURL.isEnabled());
    }

    @Test
    public void download_data(){
        byte[] result = new byte[] {};
        activity.downloadFinished(result);

        /**
         * useLibrary 'org.apache.http.legacy'
        */

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent intent = new Intent(activity, ResultActivity.class);
        intent.putExtra("RESULT", result);
        assertThat(shadowActivity.getNextStartedActivity()).isEqualTo(intent);

    }

    @Test
    public void should_not_be_null(){
        assertThat(activity).isNotNull();
    }


    @Config(qualifiers="fr-land")
    @Test
    public void should_display_things_in_french() {
        assertEquals(activity.nameView.getText().toString(), "Bojuer!");

    }

    @Test
    public void test_for_toast_msg(){
        /**
         * Hamcrest
         * Roboelectric
         * Hamcrest
         */

        assertThat(activity.downloadBtn).isNotNull();
        activity.downloadBtn.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo(activity.getString(R.string.roboelectric_rocks)));
    }

    @Test
    public void test_list() throws IndexOutOfBoundsException{
        List<Integer> numbers =  Arrays.asList(2,3,4,5,6);

        assertThat(numbers, hasSize(5));
        //assertThat(numbers, contains(4)); //fails
        //assertThat(numbers, containsInAnyOrder(2, 4, 5));//fails
        //assertThat(numbers, everyItem(greaterThan(6))); //fails
        //assertEquals(numbers.size(), 2);//fails
    }

    @Test
    public void test_number() throws Exception{
        assertThat(Math.sqrt(-1), is(IsNotAnumber.notANumber()));
    }

    @Test
    public void test_regular_expression_matcher() throws Exception {
        String s ="mike";
        assertThat(s, RegexClass.matchesRegex("mike"));
    }

}






/**
 *
 * allOf - matches if all matchers match (short circuits)

 anyOf - matches if any matchers match (short circuits)

 not - matches if the wrapped matcher doesn't match and vice versa

 equalTo - test object equality using the equals method

 is - decorator for equalTo to improve readability

 hasToString - test Object.toString

 instanceOf, isCompatibleType - test type

 notNullValue, nullValue - test for null

 sameInstance - test object identity

 hasEntry, hasKey, hasValue - test a map contains an entry, key or value

 hasItem, hasItems - test a collection contains elements

 hasItemInArray - test an array contains an element

 closeTo - test floating point values are close to a given value

 greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - test ordering

 equalToIgnoringCase - test string equality ignoring case

 equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace

 containsString, endsWith, startsWith - test string matching

 *
 */
