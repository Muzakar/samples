package com.mk.sample.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayElement implements Delayed {

    private final String element;
    private final long expiryTime;

    public DelayElement(String element, long expiryTime) {
        this.element = element;
        this.expiryTime = System.currentTimeMillis() + expiryTime;
    }

    @Override
        public long getDelay(TimeUnit unit) {
        long diff = expiryTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.expiryTime < ((DelayElement) o).expiryTime) {
            return -1;
        }
        if (this.expiryTime > ((DelayElement) o).expiryTime) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return element + ": " + expiryTime;
    }

}
