package com.darsh.stringbuilder.stringbuffer.stringbuilder;

public class StringBuilderDemo {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder("");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    stringBuilder.append("A");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    stringBuilder.append("B");
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    stringBuilder.append("C");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("String builder is non synchronized, " +
                "that means never ❌ use it in multithreaded env without proper synchronization");
        System.out.println(stringBuilder);

        //Output without proper synchronisation : BCCCBCBBCBBBCCBBCBBCCCCCBBBBBBBBBBCBBBBBBCCCBBCCBBCCBCCCCCCCCCCC
    }
}
