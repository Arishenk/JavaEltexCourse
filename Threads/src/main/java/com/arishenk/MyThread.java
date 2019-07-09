package com.arishenk;

public class MyThread implements Runnable {
    public  Integer number;
    public Printer printer;

    @Override
    public void run() {
        System.out.println(this.number);
        printer.increment();
    }

    public MyThread(Integer number, Printer printer) {
        this.number = number;
        this.printer = printer;
    }
}
