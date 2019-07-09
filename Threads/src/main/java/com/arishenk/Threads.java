package com.arishenk;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread(i, printer);
            Thread t = new Thread(r);
            t.start();
        }
        Thread.sleep(3000);
        System.out.println("a = " + Printer.a);
    }
}
