package com.fada21.android.bootstrap;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18, reportSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class HomeActivityRoboTest {

    @Test
    public void testHomeActivityNotNull() throws Exception {
        //=== Not working with new Appcompat. No theming(22 - 10 - 2014https://chris.banes.me/2014/10/17/appcompat-v21/)
        Activity activity = Robolectric.buildActivity(HomeActivity.class).create().get();
        assertTrue(activity != null);
    }

    // examples - https://github.com/paweldudek/android-tdd-workshop/tree/robolectric_solution/robolectric/src/test/java/pl/mobilewarsaw/robolectric
    // on branch robolectric_solution

}