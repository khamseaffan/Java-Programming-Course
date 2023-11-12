package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println(ANSI_BLUE + "Hello From "+ currentThread().getName());

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE+"Another Thread Wake Me up");
            return;
        }

        System.out.println(ANSI_BLUE + "I Have Wake Up After 3 sec");

    }
}
