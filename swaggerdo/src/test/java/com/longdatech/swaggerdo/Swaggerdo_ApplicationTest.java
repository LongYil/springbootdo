package com.longdatech.swaggerdo;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Swaggerdo_ApplicationTest {

    public static void main(String[] args) throws Exception {
        Random random = new Random();

        System.out.println(random.nextInt(10) * 1000);
    }

    @Test
    public void test1() throws Exception {
        Method[] methods = Object.class.getMethods();
        Proxy proxy;
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
    }

    @Test
    public void test2() throws Exception {

        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();

    }


    volatile List<String> list = new ArrayList<>();
     AtomicInteger p = new AtomicInteger(0);
    Object o = new Object();
    @Test
    public void test3() throws Exception {
        long start,end,used;
        start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 100000000) {
                i++;
//                synchronized (o){
                int t = p.get();
                p.set(t++);
//                }
            }
        });
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (i < 100000000) {
                i++;
//                synchronized (o){
                int t = p.get();
                p.set(t++);
//                }
            }
        });
        thread.start();
        thread1.start();

        System.out.println("2000000000");

        thread.join();
        thread1.join();
        end = System.currentTimeMillis();
        used = end - start;
        System.out.println(used + ":" + p);
    }





    public class MonitorObject {
    }

    public class MyWaitNotify {

        MonitorObject myMonitorObject = new MonitorObject();

        public void doWait() {
            synchronized (myMonitorObject) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void doNotify() {
            synchronized (myMonitorObject) {
                myMonitorObject.notify();
            }
        }
    }

    @Test
    public void test4() throws Exception {
        MyWaitNotify obj = new MyWaitNotify();
        Object o = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程1开始");
                    obj.doWait();
                    System.out.println("等待1结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程2开始");
                    obj.doWait();
                    System.out.println("等待2结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();

        Thread.sleep(3000);

        obj.doNotify();
        obj.doNotify();

        Thread.sleep(5000);
    }

    @Test
    public void test5() throws Exception{
        InheritableThreadLocal inheritableThreadLocal = null;

    }

}
