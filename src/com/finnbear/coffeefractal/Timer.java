package com.finnbear.coffeefractal;

/**
 * © 2017 Finn Bear All Rights Reserved
 */

public class Timer {
    private long startTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public long endTimer() {
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
