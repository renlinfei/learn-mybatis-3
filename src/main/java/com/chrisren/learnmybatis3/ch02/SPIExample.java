package com.chrisren.learnmybatis3.ch02;

import org.junit.Test;

import java.sql.Driver;
import java.util.ServiceLoader;

public class SPIExample {

    @Test
    public void testSPI() {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver: drivers) {
            System.out.println(driver.getClass().getName());
        }
    }
}
