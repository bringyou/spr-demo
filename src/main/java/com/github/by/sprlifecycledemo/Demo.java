package com.github.by.sprlifecycledemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class Demo implements DisposableBean {
    private final LifecycleBean lifecycle;

    private final NormalBean normalBean;

    public Demo(LifecycleBean lifecycle, NormalBean normalBean) {
        this.lifecycle = lifecycle;
        this.normalBean = normalBean;
    }

    @Override
    public void destroy() throws Exception {
        boolean isLifecycleBeanRunning = lifecycle.isRunning();
        System.out.println("isLifecycleBeanRunning = " + isLifecycleBeanRunning);
        boolean isNormalBeanRunning = normalBean.isRunning();
        System.out.println("isNormalBeanRunning = " + isNormalBeanRunning);
    }
}
