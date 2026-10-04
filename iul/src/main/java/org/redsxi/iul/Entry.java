package org.redsxi.iul;

public class Entry {
    public static void iulEntry() {
        System.out.println("Hello, IUL world!");
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("ClassLoader: " + Entry.class.getClassLoader().toString());
        System.out.println("ThreadClassLoader: " + Thread.currentThread().getClass().getClassLoader().toString());
        throw new RuntimeException("WOWOWWWWWWW");
    }
}
