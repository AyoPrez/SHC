package com.ayoprez.speechhelpercards.ui.activity;

import com.ayoprez.speechhelpercards.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by ayo on 14.05.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    @Test
    public void shouldNotBeNull(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);
    }

}