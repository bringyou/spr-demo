package com.github.by.sprlifecycledemo;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class LifecycleBean implements Lifecycle {
    private final AtomicBoolean running = new AtomicBoolean(false);
    @Override
    public void start() {
        running.compareAndSet(false, true);
    }

    @Override
    public void stop() {
        running.compareAndSet(true, false);
    }

    @Override
    public boolean isRunning() {
        return running.get();
    }
}
