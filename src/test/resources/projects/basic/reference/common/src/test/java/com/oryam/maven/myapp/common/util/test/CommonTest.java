package com.oryam.maven.myapp.common.util.test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

public abstract class CommonTest {

    protected static final Logger LOG = LoggerFactory.getLogger(CommonTest.class);

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        LOG.debug("=== Running test {} ===", testName.getMethodName());
    }

    public static void sleep(TimeUnit unit, long timeout) {
        try {
            LOG.trace("Waiting test {} {}", timeout, unit);
            unit.sleep(timeout);
            LOG.debug("Waited test {} {} done", timeout, unit);
        } catch (InterruptedException e) {
            LOG.error("Failed to sleep thread!", e);
        }
    }

    public static void fast() {
        sleep(TimeUnit.MILLISECONDS, 100);
    }

    public static void sleep() {
        sleep(TimeUnit.SECONDS, 2);
    }

    public static void slow() {
        sleep(TimeUnit.SECONDS, 5);
    }

    protected Object unwrapProxy(final Object bean) {
        /*
         * If the given object is a proxy, set the return value as the object
         * being proxied, otherwise return the given object.
         */
        Object out = null;
        if (AopUtils.isAopProxy(bean) && bean instanceof Advised) {
            Advised advised = (Advised) bean;
            try {
                out = advised.getTargetSource().getTarget();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return out;
    }

}
