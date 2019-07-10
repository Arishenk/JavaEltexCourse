package com.arishenk;

public class Printer {
    static public Integer a = 0;

    public synchronized void increment() {
        a += 1;
    }
}
