package com.zhengjianbin.algorithm.twoadd;

/**
 * Created by zhengjianbin on 2019/7/2.
 */
public class LinkNode {

    private LinkNode next;
    private Integer value;

    public LinkNode(Integer value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
