package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import name.juhasz.judit.udacity.joketeller.JokeDisplayActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public IntentsTestRule<MainActivity> mMainActivityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickOnTellJoke_displayLoadedJoke() throws Exception {
        // Given: A MainActivity
        // When: Click on the "Tell joke" button which will trigger the AsyncTask
        // that opens a JokeDisplayActivity. The joke is passed to the activity in
        // an intent extra.
        onView(withId(R.id.b_tell_joke)).perform(click());

        // Then: The proper intent is started with the joke extra
        intended(
                allOf(hasComponent(JokeDisplayActivity.class.getCanonicalName()),
                        hasExtraWithKey(JokeDisplayActivity.EXTRA_DATA)
                )
        );
    }
}
