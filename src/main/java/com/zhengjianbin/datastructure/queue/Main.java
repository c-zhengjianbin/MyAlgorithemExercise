package com.zhengjianbin.datastructure.queue;

import com.zhengjianbin.datastructure.queue.arrqueue.ArrayQueue;
import com.zhengjianbin.datastructure.queue.linknodequeue.LinkNodeQueue;

/**
 * Created by zhengjianbin on 2019/8/15.
 */
public class Main {


    public static void main(String[] args){

        LinkNodeQueue linkNodeQueue = new LinkNodeQueue();
        /**
         * 测试链表队列
         */
        for(int i = 0; i < 5; i++){
            linkNodeQueue.enter(i);
        }
        System.out.println(linkNodeQueue.out().getValue());
        System.out.println(linkNodeQueue.out().getValue());
        System.out.println(linkNodeQueue.out().getValue());
        System.out.println(linkNodeQueue.out().getValue());
        System.out.println(linkNodeQueue.out().getValue());
        /**
         * 测试数组队列

        ArrayQueue queue = new ArrayQueue(5);
        for(int i = 0; i < 5; i++){
            queue.v2Enter(Integer.toString(i));
        }
        System.out.println(queue.toString());
        queue.v2Out();
        queue.v2Out();
        System.out.println(queue.v2Enter(Integer.toString(5)));
        System.out.println(queue.toString());
         */
    }

}
