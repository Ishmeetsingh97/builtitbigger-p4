package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class JokeTester extends ApplicationTestCase<Application> implements JokeListener {

    CountDownLatch msignal;
    String mjoke;

    public JokeTester() {
        super(Application.class);
    }

    public void testJoker() {
        try {
            msignal = new CountDownLatch(1);
            new EndpointAsync().execute(this);
            msignal.await(10, TimeUnit.SECONDS);
            assertNotNull("null", mjoke);
            assertFalse("empty", mjoke.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    @Override
    public void onReceived(String joke) {
        this.mjoke = joke;
        msignal.countDown();
    }
}
