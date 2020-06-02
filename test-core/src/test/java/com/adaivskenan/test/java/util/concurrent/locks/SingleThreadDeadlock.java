package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SingleThreadDeadlock {
    public static void main(String[] args) {   
        System.out.println("starting");
        ReadWriteLock lock = new ReentrantReadWriteLock();

        lock.readLock().lock();
        lock.writeLock().lock();
        System.out.println("done");
    }
}