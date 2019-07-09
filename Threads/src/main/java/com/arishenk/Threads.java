package com.arishenk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Fi1 fi1 = new Fi1();
        Runnable[] run = new Runnable[10];
        ExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 10; i++) {
            run[i] = new MyThread(i, printer, fi1);
            exec.submit(run[i]);
        }
        Thread.sleep(3000);
        exec.shutdown();
        System.out.println("a = " + Printer.a);
        System.out.println("b = " + Fi1.b);
    }
}
