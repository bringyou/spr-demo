package com.github.by.sprlifecycledemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class NormalBean implements DisposableBean {
    private final AtomicBoolean running = new AtomicBoolean(true);
    @Override
    public void destroy() throws Exception {
        running.set(false);
    }

    public boolean isRunning() {
        return running.get();
    }
}
