package com.zhengjianbin.algorithm.queuealgorithm.getrecentreqcounter;

import com.sun.org.apache.regexp.internal.RE;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhengjianbin on 2019/7/23.
 */
public class Main {

    /**
     * 题目：
     *    写一个 RecentCounter 类来计算最近的请求。
     *    它只有一个方法：ping(int t)，其中t 代表以毫秒为单位的某个时间。
     *    返回从 3000 毫秒前到现在的 ping 数。
     *    任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）
     * 的 ping。
     *    保证每次对 ping 的调用都使用比之前更大的 t 值。
     *
     * 示例：
     *    输入：inputs = ["RecentCounter","ping","ping","ping","ping"],
     *         inputs = [[],[1],[100],[3001],[3002]]
     *    输出： [null,1,2,3,3]
     *
     * 题意：
     *    计算三秒之内的Ping 数。
     *    在1ms 时，发送一个ping 请求，在1ms 这一刻三秒之内的请求为 1
     *    在100ms 时，发送一个ping 请求，在100ms 这一刻三秒之内的请求为 2
     *    在3001ms 时，发送一个ping 请求，在3001ms 这一刻三秒之内的请求为 3（包括1ms 时发送的请求）
     *    在3002ms 时，发送一个ping 请求，在3002ms 这一刻三秒之内的请求为 3 （100ms、3001ms、3002ms）
     */
    public static void main(String[] args){
        RecentCounter recentCounter = new RecentCounter();
        Flowable.just(recentCounter).delay(1, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                   System.out.println("1ms 发送ping 请求数量:"+o.ping(1));
                });

        Flowable.just(recentCounter).delay(100, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                    System.out.println("100ms 发送ping 请求数量:"+o.ping(100));
                });

        Flowable.just(recentCounter).delay(3001, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                    System.out.println("3001ms 发送ping 请求数量:"+o.ping(3001));
                });

        Flowable.just(recentCounter).delay(3050, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                    System.out.println("3050ms 发送ping 请求数量:"+o.ping(3050));
                });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
