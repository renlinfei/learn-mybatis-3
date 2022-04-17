package com.chrisren.learnmybatis3.others;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void testJDKProxy() {
        final IAnimal animal = new Dog();
        Object proxyObject = Proxy.newProxyInstance(animal.getClass().getClassLoader(),
                animal.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("被拦截的方法：" + method.getName());
                        return method.invoke(animal, args);
                    }
                });
        if (proxyObject instanceof IAnimal) {
            System.out.println("proxy is an animal");
        } else {
            System.out.println("proxy isn't an animal");
        }
        if (proxyObject instanceof Dog) {
            System.out.println("proxy is an Dog");
        } else {
            System.out.println("proxy isn't an Dog");
        }

        IAnimal animal1Proxy = (IAnimal) proxyObject;
        animal1Proxy.info();
        animal1Proxy.eat();
        animal1Proxy.hashCode();
        System.out.println(animal1Proxy.getClass().getName().toString());
    }

    @Test
    public void test() {
        final IAnimal animal = new Dog();
        System.out.println(animal.getClass().getClassLoader());
        System.out.println(animal.getClass().getInterfaces());
    }
}
