package com.mk.sample.delayqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private Logger logger = LogManager.getLogger();

    private final BlockingQueue<DelayElement> blockingQueue;

    public Producer(BlockingQueue<DelayElement> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                DelayElement delayElement = new DelayElement(UUID.randomUUID().toString(), 5000);
                logger.info("Put: " + delayElement);
                blockingQueue.put(delayElement);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
