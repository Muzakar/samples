package com.mk.sample.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Muzakar on 18/12/2017.
 */
public class DelayQueueSample {

    public static void main(String[] args) {
        DelayQueueSample sample = new DelayQueueSample();
        sample.start();
    }

    private void start() {
        final BlockingQueue<DelayElement> queue = new DelayQueue<DelayElement>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(new Producer(queue));
        executor.execute(new Consumer(queue));
    }

}
