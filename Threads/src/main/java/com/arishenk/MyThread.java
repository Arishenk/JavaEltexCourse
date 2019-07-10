package com.arishenk;

//import org.jetbrains.annotations.Nullable;

import java.util.Queue;

public class MyThread<T extends Queue> implements Runnable {

    //@Nullable
    public Integer number;

//    @Nullable
    public Printer printer;

    public Fi1 fi1;
    public T queue;

    //@Override
    public void run() {
            queue.add(this.number);
        /*printer?.increment();
        try {
            fi1.eat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public MyThread(Integer number/*, Printer printer, Fi1 fi1,*/, T queue) {
       // this.fi1 = fi1;
        this.number = number;
       // this.printer = printer;
        this.queue = queue;
    }
}
