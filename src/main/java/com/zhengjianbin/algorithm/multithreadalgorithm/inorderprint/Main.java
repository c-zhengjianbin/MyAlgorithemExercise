package com.zhengjianbin.algorithm.multithreadalgorithm.inorderprint;

import com.sun.tools.javac.comp.Flow;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by zhengjianbin on 2019/7/23.
 */
public class Main {


    /**
     * 题目：
     *    我们提供一个类{@link Foo}，该类中有三个方法。三个不同的线程
     * 将会共用一个{@link Foo} 实例。
     *    线程A 将会调用first() 方法。
     *    线程B 将会调用second() 方法。
     *    线程C 将会调用third() 方法。
     *    请设计并修改中{@link Foo}的方法，以确保second() 方法在first() 方
     *  法之后执行，third() 方法在second() 方法之后执行。
     *
     * 示例：
     *    示例1：
     *    输入：[1,2,3]
     *    输出：first second third
     *    解释：有三个线程会被异步启动。线程A 将会调用first() 方法，线程B将
     * 会调用second() 方法，线程C 将会调用third() 方法。
     *         正确的输出结果是：first second third
     *
     *    示例2：
     *    输入：[1,3,2]
     *    输出：first third second
     *    介绍：输入[1,3,2] 表示线程A 将会调用first() 方法，线程B 将会调用
     * third() 方法，线程C 将会调用second() 方法。
     *         正确的输出是first second third
     *
     * 注意：
     *    尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度
     * 顺序。
     *    你看到的输入格式主要是为了确保测试的全面性。
     *
     */
    public static void main(String[] args) throws InterruptedException {
//        Foo foo = new Foo();

        FooUseCountDownLatch foo = new FooUseCountDownLatch();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t1.start();
        t2.start();
    }

}
