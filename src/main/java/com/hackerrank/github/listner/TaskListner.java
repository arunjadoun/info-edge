package com.hackerrank.github.listner;

import com.hackerrank.github.service.TestProcessor;
import com.infoedge.model.Test;
import org.springframework.stereotype.Component;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskListner implements Runnable {

    private PriorityBlockingQueue<Test> queue = new PriorityBlockingQueue<>();
    private TestProcessor testProcessor;

    public PriorityBlockingQueue<Test> getQueue() {
        return queue;
    }

    public TaskListner(PriorityBlockingQueue<Test> queue, TestProcessor testProcessor) {
        this.queue = queue;
        this.testProcessor = testProcessor;
    }

    public void setQueue(PriorityBlockingQueue<Test> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Test test = queue.peek();
            if (test != null && test.getEndTime() > System.currentTimeMillis()) {
                queue.poll();
                testProcessor.notify(test);
            }
        }
    }
}
