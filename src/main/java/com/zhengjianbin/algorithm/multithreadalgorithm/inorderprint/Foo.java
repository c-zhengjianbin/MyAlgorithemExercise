package com.zhengjianbin.algorithm.multithreadalgorithm.inorderprint;

/**
 * Created by zhengjianbin on 2019/7/23.
 */
public class Foo {

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException{
        //TODO

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable secondFirst) throws InterruptedException{
        //TODO

        // printSecond.run() outputs "second". Do not change or remove this line.
        secondFirst.run();
    }

    public void third(Runnable thirdFirst) throws InterruptedException{
        //TODO

        // printThird.run() outputs "third". Do not change or remove this line.
        thirdFirst.run();
    }

}
