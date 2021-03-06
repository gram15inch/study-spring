package com.example.test2.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class JunitTest {
    @Autowired
    ApplicationContext context;

    static Set<JunitTest> testObjects = new HashSet<JunitTest>();
    static ApplicationContext contextObject = null;

    @Test
    public void test1(){
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);

        assertThat(contextObject == null || contextObject == this.context,is(true));
        contextObject = this.context;
    }
    @Test
    public void test2(){
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);

        assertTrue(contextObject == null || contextObject == this.context);
        contextObject = this.context;
    }
    @Test
    public void test3(){
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);

        assertThat(contextObject,
               either(is(nullValue())).or(is(this.context)));
        contextObject = this.context;
    }

}
