package me.christian.rs.util;

public class Timer {

    private long timestamp;

    public Timer() {
        timestamp = 0L;
        resetClocks();
    }

    public boolean hasTimeElapsed(long milliseconds) {
        long nanoseconds = (long) (milliseconds * 1E+6);

        boolean passed = getTimeElapsed() >= nanoseconds;

        if (passed)
            resetClocks();
        return passed;
    }

    public long getTimeElapsed() {
        return Math.abs(nano() - timestamp);
    }

    public long nano() {
        return System.nanoTime();
    }

    public void resetClocks() {
        timestamp = nano();
    }

}