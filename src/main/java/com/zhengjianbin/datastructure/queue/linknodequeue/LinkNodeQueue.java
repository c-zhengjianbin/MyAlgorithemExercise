package com.zhengjianbin.datastructure.queue.linknodequeue;

import com.zhengjianbin.algorithm.linkedlistalgorithm.twoadd.LinkNode;

/**
 * Created by zhengjianbin on 2019/8/20.
 */
public class LinkNodeQueue {

    /**
     * 思路：
     *   在使用链表实现队列时，我们先直观的看一下，链表与数组的有哪些区别？
     *   --访问：数组支持使用下标的方式访问数组内的每一个元素；而链表无法支持。
     *   --修改：在修改数组内数据时，为维护内存地址的连续性，需要进行数据迁移；而链表无需进行数据迁移。
     *   --扩容：数组一旦被创建后，每次扩容都需要创建新数据，并将数据拷贝到新数组内；链表在扩容时，无需
     * 拷贝数据。
     *
     *   正是由于这样的差距，在使用链表实现队列时，势必会截然不同，下面将具体分析在不同操作下的不同之处。
     *   --入队：数组在插入时，会检查是否存在插入所需空间；链表则无需进行此项操作，因为在扩展时，只需创建
     * 一个新的结点即可。
     *   --出队：在出队时，只需设置head 结点即可。在这里只是出队的方式不同而已，数组采用下标，链表则直接
     * 使用将头结点赋值。
     *
     * 解读：
     *    链表实现队列时，重点在于新的结点入队时，如何将新结点与前面结点关联。下面代码将借助一个current 结
     * 点，来实现与原有数据关联。
     *
     */

    private LinkNode head;
    private LinkNode tail;
    private LinkNode current;

    public LinkNodeQueue() {
    }

    public boolean enter(int number){
        if(head == null){
            head = new LinkNode(number);
            current = head;
            return true;
        }
        LinkNode dataNode = new LinkNode(number);
        tail = dataNode;
        current.setNext(dataNode);
        current = tail;
        return true;
    }

    public LinkNode out() {
        if(head == null){
            return null;
        }
        LinkNode headNode = head;
        if(headNode.getNext() != null){
            head = headNode.getNext();
        }
        return headNode;
    }

}
