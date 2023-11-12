package com.company;
import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello Form Main Thread");

        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        anotherThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"Hello From Anomynous Thread");
            }
        }.start();

        Thread myRunnableThread  = new Thread(new MyRunnable() {
            @Override
            public void run() {
                super.run();
                System.out.println(ANSI_RED + "Hello from anonymous class's implementation of run");
                try{
                    anotherThread.join();
                    System.out.println(ANSI_RED + "Waited for another thread to get terminated");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "There was interruption while waiting for another thread to complete");
                }
            }
        });

        myRunnableThread.start();

        System.out.println(ANSI_PURPLE+ "Hello again Form Main Thread ");

    }
}
