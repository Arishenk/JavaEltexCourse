package com.arishenk;

public class MyThread implements Runnable {
    public  Integer number;

    @Override
    public void run() {
        System.out.println(this.number);
    }

    public MyThread(Integer number) {
        this.number = number;
    }
}
