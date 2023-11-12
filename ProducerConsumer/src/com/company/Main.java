package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService  = Executors.newFixedThreadPool(5);

        executorService.execute(new MyProducer(buffer, ThreadColor.ANSI_GREEN));
        executorService.execute(new MyConsumer(buffer, ThreadColor.ANSI_RED));
        executorService.execute(new MyConsumer(buffer, ThreadColor.ANSI_PURPLE));

        //ExecutorService class can use to get value of a background thread
        // using executorService.submit() which returns future object

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_BLUE+"I Am called from Callable Class");
                return ThreadColor.ANSI_BLUE+"Getting Object of Future to print String";
            }
        });
        try{
            System.out.println(future.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println("Something Went Wrong");
        }
//        new Thread(new MyProducer(buffer, ThreadColor.ANSI_GREEN, bufferLock)).start();
//        new Thread(new MyConsumer(buffer, ThreadColor.ANSI_RED, bufferLock)).start();
//        new Thread(new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock)).start();

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            System.out.println(color + "Adding..." + num);
//            synchronized (buffer) {
//                buffer.add(num); When Array List Was used
////            }
//            bufferLock.lock(); ReentrantLock was used for these lines
//            buffer.add(num);
//            bufferLock.unlock();

            try {
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
        System.out.println(color + "Adding...EOF and Exiting");
//        synchronized (buffer) {
//            buffer.add(EOF);
////        }
//        bufferLock.lock();
//        try {
//            buffer.add((EOF));
//        }finally{
//            bufferLock.unlock();
//        }

        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {

//            synchronized (buffer) {
//                if (buffer.isEmpty()) {
//                    continue;
//                }
//                if (buffer.get(0).equals(EOF)) {
//                    System.out.println(color + "Exiting");
//                    break;
//                } else {
//                    System.out.println(color + "Removed " + buffer.remove(0));
//                }
//            }
//            bufferLock.lock();
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }

            }
        }
    }
}