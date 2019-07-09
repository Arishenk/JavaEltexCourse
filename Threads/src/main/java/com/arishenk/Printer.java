package com.arishenk;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    static public volatile Integer a = 0;

    public void increment() {
        a += 1;
    }
}
