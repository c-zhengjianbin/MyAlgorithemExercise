package com.zhengjianbin.algorithm.multithreadalgorithm.printzerooddeven;

import com.zhengjianbin.algorithm.multithreadalgorithm.inorderprint.Foo;

/**
 * Created by zhengjianbin on 2019/8/1.
 */
public class Main {

    /**
     * 题目：
     *    我们提供一个类{@link ZeroOddEven}，该类中有三个方法。三个不同的线程
     * 将会共用一个{@link ZeroOddEven} 实例。
     *    线程A 将会调用zero() 方法，它只输出0。
     *    线程B 将会调用even() 方法，它只输出偶数。
     *    线程C 将会调用odd() 方法，它只输出奇数。
     *    每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出
     * 整数序列 010203040506... ，其中序列的长度必须为 2n。
     *    请设计并修改中{@link ZeroOddEven}的方法，保证按规则进行输出。
     *
     * 示例：
     *    示例1：
     *    输入：n = 2
     *    输出：0102
     *    解释：三条线程异步执行，其中一个调用zero()，另一个线程调用even，最后一个线程
     * 调用odd()。正确的输出为："0102".
     *
     *    示例2：
     *    输入：n = 5
     *    输出："0102030405"
     *
     */
    public static void main(String[] args){
        ZeroOddEven zeroOddEven = new ZeroOddEven(5);

        Thread t1 = new Thread(() -> {
            try {
                zeroOddEven.zero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroOddEven.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroOddEven.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t1.start();
        t2.start();

    }



}
