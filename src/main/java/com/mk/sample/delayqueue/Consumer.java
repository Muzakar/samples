package com.mk.sample.delayqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private Logger logger = LogManager.getLogger();

    private final BlockingQueue<DelayElement> blockingQueue;

    public Consumer(BlockingQueue<DelayElement> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                DelayElement delayElement = blockingQueue.take();
                logger.info(Thread.currentThread().getName() + " take(): " + delayElement);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
