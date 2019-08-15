package com.zhengjianbin.datastructure.queue;

import com.zhengjianbin.datastructure.queue.arrqueue.ArrayQueue;

/**
 * Created by zhengjianbin on 2019/8/15.
 */
public class Main {


    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(5);
        for(int i = 0; i < 5; i++){
            queue.enter(Integer.toString(i));
        }
        System.out.println(queue.toString());
        queue.v1Out();
        queue.v1Out();
        queue.v1Out();
        queue.enter(Integer.toString(5));
        queue.enter(Integer.toString(6));
        queue.enter(Integer.toString(7));
        queue.enter(Integer.toString(8));
        System.out.println(queue.toString());
    }

}
