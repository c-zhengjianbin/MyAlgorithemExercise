package com.zhengjianbin.algorithm.multithreadalgorithm.inorderprint;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhengjianbin on 2019/7/26.
 */
public class FooUseCountDownLatch {

    private CountDownLatch first = new CountDownLatch(1);
    private CountDownLatch second = new CountDownLatch(1);

    public FooUseCountDownLatch() {
    }

    public void first(Runnable printFirst) throws InterruptedException{
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable secondFirst) throws InterruptedException{
        first.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        secondFirst.run();
        second.countDown();
    }

    public void third(Runnable thirdFirst) throws InterruptedException{
        second.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        thirdFirst.run();
    }

}
