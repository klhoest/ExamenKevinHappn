package com.lhoest.kevin.happn.examenkevinhappn

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Make sure your animations are disabled
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ForecastTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickOnListToSeeDetail() {
        TestUtils.waitForWithToBeDisplayed(R.id.list)
        val viewActionOnItem =
                RecyclerViewActions.actionOnItemAtPosition<MySummaryRecyclerViewAdapter.ViewHolder>(1, click())
        onView(withId(R.id.list))
                .perform(viewActionOnItem)
        TestUtils.waitForWithToBeDisplayed(R.id.raw_content)
        onView(withId(R.id.raw_content)).check(matches(isDisplayed()))
    }
}
