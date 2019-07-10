package com.arishenk;

import java.util.Queue;
import java.util.concurrent.*;

public class Threads {
    public static ArrayBlockingQueue<Integer> arrayQueue = new ArrayBlockingQueue<Integer>(10);
    public static LinkedBlockingQueue<Integer> linkedQueue = new LinkedBlockingQueue<Integer>(10);
    public static LinkedBlockingDeque<Integer> linkedDeque = new LinkedBlockingDeque<Integer>(10);
    public static SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
    public static LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue<>();
    public static DelayQueue delayQueue = new DelayQueue();
    public static PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Fi1 fi1 = new Fi1();
        Runnable[] run = new Runnable[10];
        ExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        /*for (int i = 0; i < 10; i++) {
            run[i] = new MyThread(i, printer, fi1);
            exec.submit(run[i]);
        }*/

        /*Thread.sleep(3000);
        exec.shutdown();
        System.out.println("\na = " + Printer.a);
        System.out.println("\nb = " + Fi1.b);*/

        getTime(arrayQueue);
        getTime(linkedQueue);
        getTime(linkedDeque);
        getTime(linkedTransferQueue);
        getTime(priorityBlockingQueue);
       // getTime(delayQueue);
        //getTime(synchronousQueue);
    }

    public static <T extends Queue> void getTime(T queue) throws InterruptedException {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread(i,/*printer, fi1,*/ queue);
            Thread t = new Thread(r);
            t.start();
        }
        long estimatedTime = System.nanoTime() - startTime;
        Thread.sleep(3000);

        Class arraysInfo = queue.getClass();
        System.out.println("\nName: " + arraysInfo.getName());

        for (Object number :queue) {
            System.out.print(number + " ");
        }

        System.out.print("\n" + estimatedTime + " ns");
    }
}
