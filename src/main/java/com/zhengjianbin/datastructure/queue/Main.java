package com.zhengjianbin.datastructure.queue;

import com.zhengjianbin.datastructure.queue.arrqueue.ArrayQueue;

/**
 * Created by zhengjianbin on 2019/8/15.
 */
public class Main {


    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(5);
        for(int i = 0; i < 5; i++){
            queue.v2Enter(Integer.toString(i));
        }
        System.out.println(queue.toString());
        queue.v2Out();
        queue.v2Out();
        System.out.println(queue.v2Enter(Integer.toString(5)));
        System.out.println(queue.toString());
    }

}
