package com.zhengjianbin.algorithm.multithreadalgorithm.printzerooddeven;

import java.lang.management.RuntimeMXBean;
import java.util.concurrent.Semaphore;

/**
 * Created by zhengjianbin on 2019/8/1.
 */
public class ZeroOddEven {

    /**
     * 思路：
     *    通过题目我们分析，zero() 方法是先执行的，然后调用一次
     * odd() 函数；然后zero() 方法再次执行，此时调用even() 方法。
     *    由于线程调用是异步的，在异步调用中如何保证我们所需的顺序，
     * 是这道题的关键。
     *    对于zero() 方法，它的每次循环执行完后，都需要等奇、偶数调用
     * 完，它才能执行下一次循环。
     *    对于odd() 方法，当是奇数时，它需要等zero() 方法调用完后，才
     * 能下一次循环。
     *    对于even() 方法，当是偶数时，它需要等zero() 方法调用完后，才能
     * 下一次循环。这就要求由zero 去控制，下次执行的方式是even还是odd？
     *    通过使用信号量，由zero() 控制even、odd 方法的调用。
     *
     * 伪代码：
     *    a.初始化控制zero 方法的信号量，并由even、odd来控制这个资源。
     *    b.初始化控制even、odd方法的信号量，由zero 来控制这两个资源。
     *    c.使用for 循环，在每次循环结束后，判断当前是奇数还是偶数，释放对应的的资源控制。
     *    d.尝试获取自身的资源许可，为下一次执行做准备。
     *    e.even、odd 方法执行完后，释放zero 方法的资源，让zero 执行下一次循环。
     */
    private int n;

    private Semaphore zeroSemaphore;

    private Semaphore oddSemaphore;

    private Semaphore evenSemaphore;

    public ZeroOddEven(int n) {
        this.n = n;
        zeroSemaphore = new Semaphore(0);
        oddSemaphore = new Semaphore(0, true);
        evenSemaphore = new Semaphore(0, true);
    }

    public void zero() throws InterruptedException {
        for(int i = 1; i <= n; i++){
            System.out.print(0);
            if(i % 2 == 0){
                //偶数
                evenSemaphore.release();
            }else{
                oddSemaphore.release();
            }
            zeroSemaphore.acquire();
        }
    }

    public void even() throws InterruptedException {
        for(int i = 2; i <= n; i+=2){
            evenSemaphore.acquire();
            System.out.print(i);
            zeroSemaphore.release();
        }
    }

    public void odd() throws InterruptedException {
        for(int i = 1; i <= n; i+=2){
            oddSemaphore.acquire();
            System.out.print(i);
            zeroSemaphore.release();
        }
    }

}
