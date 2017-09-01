package com.oryam.maven.myapp.common.util.test;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

/**
 * Factory based on random-beans. Only used in tests.
 * 
 * @see https://github.com/benas/random-beans
 */
public class BeanFactoryTest {

    public static final BeanFactoryTest INSTANCE = new BeanFactoryTest();

    private EnhancedRandom enhancedRandom;

    private BeanFactoryTest() {
        enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandom();
    }

    public <T> T getRandomObject(Class<T> clazz, String... excludeFields) {
        return enhancedRandom.nextObject(clazz, excludeFields);
    }

}
