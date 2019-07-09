package com.arishenk;

public class MyThread implements Runnable {
    public  Integer number;
    public Printer printer;
    public Fi1 fi1;

    @Override
    public void run() {
        System.out.println(this.number);
        printer.increment();
        try {
            fi1.eat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyThread(Integer number, Printer printer, Fi1 fi1) {
        this.number = number;
        this.printer = printer;
        this.fi1 = fi1;
    }
}
