package com.zhengjianbin.algorithm.multithreadalgorithm.alternatelyprint;

import com.zhengjianbin.algorithm.multithreadalgorithm.inorderprint.Foo;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by zhengjianbin on 2019/7/29.
 */
public class Main {

    /**
     * 题目：
     *    我们提供一个类{@link FooBar}，该类中有两个方法。两个不同的线程
     * 将会共用一个{@link FooBar} 实例。
     *    其中一个线程调用foo() 方法。
     *    另一个线程调用bar() 方法。
     *    请设计并修改中{@link FooBar}的方法，以确保"foobar"被输出n次
     *
     * 示例：
     *    示例1：
     *    输入：n = 1
     *    输出：foobar
     *    解释：这里有两个线程被异步启动。其中一个调用foo() 方法，另一个调用bar() 方法，
     *    "foobar" 输出一次。
     *
     *    示例2：
     *    输入：n = 2
     *    输出：foobarfoobar
     *    解释："foobar" 将被输出两次
     *
     */
    public static void main(String[] args){
        FooBar fooBar = new FooBar(2);
        Thread t1 = new Thread(() -> {
            try {
                try {
                    fooBar.foo(() -> System.out.print("foo"));
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }



}
