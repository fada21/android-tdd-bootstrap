package com.fada21.android.bootstrap.espresso;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.fada21.android.bootstrap.PlainActivityNoApc;
import com.fada21.android.bootstrap.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class PlainActivityNoApcEspressoTest extends ActivityInstrumentationTestCase2<PlainActivityNoApc> {

    public PlainActivityNoApcEspressoTest() {
        super(PlainActivityNoApc.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testPlainActivityExits() {
        assertNotNull(getActivity());
    }

    public void testCheckPlainButtonDisplays() {
        onView(withId(R.id.tv_home_top))
                .check(matches(isDisplayed()));
    }

}
