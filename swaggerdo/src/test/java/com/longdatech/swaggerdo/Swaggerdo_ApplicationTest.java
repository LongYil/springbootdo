package com.longdatech.swaggerdo;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class Swaggerdo_ApplicationTest {

    public static void main(String[] args) throws Exception{
        Random random = new Random();

        System.out.println(random.nextInt(10) * 1000);
    }

    @Test
    public void test1() throws Exception{
        Method[] methods = Object.class.getMethods();
        Proxy proxy;
        for (int i = 0; i < methods.length; i++){
            System.out.println(methods[i].getName());
        }
    }
}
