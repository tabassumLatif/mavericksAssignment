package com.mavericks.assignment;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import static junit.framework.Assert.assertEquals;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}