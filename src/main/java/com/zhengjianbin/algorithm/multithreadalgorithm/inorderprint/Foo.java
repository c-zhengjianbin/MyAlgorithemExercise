package com.zhengjianbin.algorithm.multithreadalgorithm.inorderprint;

/**
 * Created by zhengjianbin on 2019/7/23.
 */
public class Foo {

    private final Object barrier = new Object();
    private boolean firstIsEnd = false;
    private boolean secondIsEnd = false;

    /**
     * 解法1：
     *    使用屏障策略。屏障的目的在于，如果方法调用依赖前一个方法，需要前一个方法释放屏障。
     * 如果前一个方法未执行，需等待方法执行完毕后，再执行此方法。
     *    注意：a.需要思考方法未执行时，如何实现等待。
     *         b.等待时，可能出现多个线程同时等待，如何唤醒？
     *    问题：如果出现多个等待，在唤醒时，会全部唤醒，增加额外处理成本。每个线程需要判断
     * 自己是否执行，而不是唤醒指定等待线程。
     *
     *
     *
     *
     *
     */
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException{
        //TODO
        synchronized (barrier){

           // printFirst.run() outputs "first". Do not change or remove this line.
           printFirst.run();
           firstIsEnd = true;
           barrier.notifyAll();
            System.out.println("first：：first 执行完成......");
        }
    }

    public void second(Runnable secondFirst) throws InterruptedException{
        //TODO
        synchronized (barrier){
            while (!firstIsEnd){
                barrier.wait();
                System.out.println("second：：first 未执行完，进入等待状态.....");
            }
            System.out.println("second：：first 执行完成......");
            // printSecond.run() outputs "second". Do not change or remove this line.
            secondFirst.run();
            secondIsEnd = true;
            barrier.notifyAll();
        }
    }

    public void third(Runnable thirdFirst) throws InterruptedException{
        //TODO
        synchronized (barrier){
            while(!secondIsEnd){
                System.out.println("third：：second 未执行完，进入等待状态.....");
                barrier.wait();
            }
            System.out.println("third：：second 执行完成......");
            // printThird.run() outputs "third". Do not change or remove this line.
            thirdFirst.run();
        }
    }

}
