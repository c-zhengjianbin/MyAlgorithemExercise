package com.zhengjianbin.datastructure.linknode.linknodemiddle;

import com.zhengjianbin.algorithm.linkedlistalgorithm.twoadd.LinkNode;

/**
 * Created by zhengjianbin on 2019/8/9.
 */
public class Main {

    public static void main(String[] args){
        LinkNode linkNode = new LinkNode(1);
        linkNode.setNext(new LinkNode(2).
                setNext(new LinkNode(3).
                                setNext(new LinkNode(3).
                                        setNext(new LinkNode(2).
                                                setNext(new LinkNode(1))))));
        System.out.println(getMiddleNode(linkNode).getValue());
    }



    /**
     * @author : zhengjianbin
     * @version: 1.0
     * @time : 2019/8/9 - 11:03 AM
     * @Param :
     * @function : 获取链表中间结点
     *
     * 原理：
     *    使用快、慢指针。快指针走两步、慢指针走一步，当快指针无法继续移动时，
     * 慢指针所在结点便是当前结点。
     */
    public static LinkNode getMiddleNode(LinkNode node){
        LinkNode fast = node, slow = node;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }


}
