package com.darsh.stringbuilder.stringbuffer.stringbuffer;

public class StringBufferDemo {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer("");
        //All methods of String-buffer are synchronised, that means consistent output

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    sb.append("A");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    sb.append("B");
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    sb.append("C");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(sb);
        //Output will be in order first 1000 A followed by B followed by C
    }
}
