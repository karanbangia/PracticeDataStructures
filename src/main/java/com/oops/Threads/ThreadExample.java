package com.oops.Threads;

import java.io.IOException;

public class ThreadExample extends Thread {
    public void run(){
        System.out.println("thread is running...");
    }
    public static void main(String args[]){
        for(int i=0;i<10;i++)
        {
            ThreadExample t = new ThreadExample();
            t.start();
        }
    }
}
class TestJoinMethod1 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){System.out.println(e);}
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        TestJoinMethod1 t1=new TestJoinMethod1();
        TestJoinMethod1 t2=new TestJoinMethod1();
        TestJoinMethod1 t3=new TestJoinMethod1();
        t1.start();
        try{
            t1.join();
        }catch(Exception e){System.out.println(e);}

        t2.start();
        t3.start();
    }
}

class TestMethod3 extends Thread{
    public void run(){
        System.out.println("running");
    }
    public static void main(String args[]){
        TestMethod3 t1=new TestMethod3();
        TestMethod3 t2=new TestMethod3();
        TestMethod3 t3=new TestMethod3();
        System.out.println(t1.getName()+"is in "+t1.getState());
        System.out.println(t2.getName()+"is in "+t2.getState());
        System.out.println(t3.getName()+"is in "+t3.getState());
        t1.start();
        System.out.println(t1.getName()+"is in "+t1.getState());
        System.out.println(t2.getName()+"is in "+t2.getState());
        System.out.println(t3.getName()+"is in "+t3.getState());
        t2.start();
        System.out.println(t1.getName()+"is in "+t1.getState());
        System.out.println(t2.getName()+"is in "+t2.getState());
        System.out.println(t3.getName()+"is in "+t3.getState());
        t3.start();
        System.out.println(t1.getName()+"is in "+t1.getState());
        System.out.println(t2.getName()+"is in "+t2.getState());
        System.out.println(t3.getName()+"is in "+t3.getState());
    }
}
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

 class TestThread {

    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
    }
}