package com.zhengjianbin.algorithm.queuealgorithm.circularqueue;

/**
 * Created by zhengjianbin on 2019/8/16.
 */
public class Main {

    /**
     * 题目：
     *    设计你的循环队列实现。循环队列是一种线性数据结构，其操作表现基于FIFO（先进先出）
     * 原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
     *    循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一
     * 个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们
     * 能使用这些空间去存储新的值。
     *    我们提供一个类{@link CircularQueue}，你需要实现类中以下方法：
     *    CircularQueue(k): 构造器，设置队列长度为 k 。
     *    front(): 从队首获取元素。如果队列为空，返回 -1 。
     *    rear: 获取队尾元素。如果队列为空，返回 -1 。
     *    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
     *    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
     *    isEmpty(): 检查循环队列是否为空。
     *    isFull(): 检查循环队列是否已满。
     *
     * 示例：
     *   MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3
     *   circularQueue.enQueue(1);  // 返回 true
     *   circularQueue.enQueue(2);  // 返回 true
     *   circularQueue.enQueue(3);  // 返回 true
     *   circularQueue.enQueue(4);  // 返回 false，队列已满
     *   circularQueue.Rear();  // 返回 3
     *   circularQueue.isFull();  // 返回 true
     *   circularQueue.deQueue();  // 返回 true
     *   circularQueue.enQueue(4);  // 返回 true
     *   circularQueue.Rear();  // 返回 4
     *
     * 注意：
     *
     *
     */
    public static void main(String[] args){

    }

}
