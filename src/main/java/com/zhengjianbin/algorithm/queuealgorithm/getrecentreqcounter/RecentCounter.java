package com.zhengjianbin.algorithm.queuealgorithm.getrecentreqcounter;

import java.util.LinkedList;

/**
 * Created by zhengjianbin on 2019/7/23.
 */
public class RecentCounter {

    private LinkedList<Integer> linkedList;

    public RecentCounter() {
        this.linkedList = new LinkedList();
    }

    public int ping(Integer t){
        linkedList.addLast(t);
        Integer tByQueue = linkedList.getFirst();
        int min = t - 3000;
        //System.out.println("头元素："+tByQueue + "最小值："+min + "最大值："+t);
        if(tByQueue != null && !(tByQueue >= min && tByQueue <= t)){
            linkedList.removeFirst();
           // System.out.println("是否移除了呢？");
        }
        return linkedList.size();
    }

}
