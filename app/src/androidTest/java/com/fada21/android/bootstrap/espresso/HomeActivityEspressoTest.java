package com.fada21.android.bootstrap.espresso;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.fada21.android.bootstrap.HomeActivity;
import com.fada21.android.bootstrap.R;

import java.util.Objects;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class HomeActivityEspressoTest extends ActivityInstrumentationTestCase2<HomeActivity> {

    private HomeActivity homeActivity;

    public HomeActivityEspressoTest() {
        super(HomeActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        //=== Not working with new Appcompat. No theming for toolbar (22 - 10 - 2014https://chris.banes.me/2014/10/17/appcompat-v21/)
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        // homeActivity = getActivity();
    }

    public void testActivityExits() {
        // assertNotNull(homeActivity);
    }

    // examples official - https://code.google.com/p/android-test-kit/wiki/EspressoStartGuide
    // examples advanced official - https://code.google.com/p/android-test-kit/wiki/EspressoSamples
    // examples - https://github.com/xrigau/droidcon-android-espresso
}
