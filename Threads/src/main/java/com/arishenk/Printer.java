package com.arishenk;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    static public Integer a = 0;

    public void increment() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        a += 1;
        lock.unlock();
    }
}
