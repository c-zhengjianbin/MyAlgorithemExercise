package com.zhengjianbin.algorithm.multithreadalgorithm.alternatelyprint;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by zhengjianbin on 2019/7/29.
 */
public class FooBar {

    private int n;

    private volatile boolean isRun = true;

    /**
     * 解法1：
     *    首先保证，foo() 方法先执行，bar() 方法后执行。
     *    其次要保证每当执行一次foo()、等bar() 执行完。才能开始下一次。
     *    引入volatile 原因是因为它的可见性。当线程更改时，另一个线程可以及时看到。如果isRun 变量不符合条件，
     * 说明另一个方法未执行。自身进入循环，实现等待。
     *    解法1的问题：总感觉使用while(!isRun){} 这种等待方式有点儿无赖，让线程进入无线循环，这是需要优化的地方。
     *    TODO ： 需想法解决此问题。
     *
     * 错误思路：
     *    使用CyclicBarrier 的错误思路：CyclicBarrier 不能保证线程顺序，它只是保证所有线程同时
     * 到达某个点。核心在于：CyclicBarrier 保证的是线程同时到达某一点，而不是保证顺序。如果需要
     * 保证顺序，需要别的支持。
     *
     */
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; i++) {
            while (!isRun){}
            printFoo.run();
            isRun = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; i++) {
            while (isRun){

            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            isRun = true;
        }
    }

}
