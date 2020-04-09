package com.philippe.mareu.model;

import android.content.Context;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.philippe.mareu.R;
import com.philippe.mareu.di.DI;
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.service.MeetingApiService;
import com.philippe.mareu.ui.MainActivity;
import com.philippe.mareu.utils.DeleteViewAction;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.philippe.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MaReuInstrumentedTest {

    private MeetingApiService service;
    private MainActivity mActivity;
    private List<Meeting> mList;
    private static int ITEMS_COUNT = 3;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        service = DI.getNewInstanceApiService();
        mList = service.getMeetings() ;

    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void Meeting_List_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and
        onView(AllOf.allOf(ViewMatchers.withId(R.id.list_meeting), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }


    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void MeetingList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_meeting), isDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_meeting), isDisplayed())).check(withItemCount(ITEMS_COUNT - 1));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.philippe.mareu", appContext.getPackageName());
    }




}
