package com.fada21.android.bootstrap;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 17, reportSdk = 15)
@RunWith(RobolectricTestRunner.class)
public class HomeActivityTest {

    @Test
    public void testSomething() throws Exception {
        Activity activity = Robolectric.buildActivity(HomeActivity.class).create().get();
        assertTrue(activity != null);
    }
}