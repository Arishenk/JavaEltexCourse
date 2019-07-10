package com.arishenk;

import java.util.concurrent.Semaphore;

public class Fi1 {
    static private Semaphore sem = new Semaphore(10);
    static public Integer b = 0;

    public void eat() throws InterruptedException {
        sem.acquire();
        b += 1;
        sem.release();
    }
}
