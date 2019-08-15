package com.zhengjianbin.datastructure.queue.arrqueue;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * Created by zhengjianbin on 2019/8/15.
 *
 * 数组实现队列
 *
 */
public class ArrayQueue {

    /**
     *
     * 思路：
     *   队列属于操作受限的数据结构，只允许在队头出队、队尾入队操作。而队列中head、tail 指针则是实现
     * 队列的关键。head 指向队头，tail 指针指向队尾。那在实现队列的，需要注意哪些问题呢？
     *   由于队列只涉及操作，只要分析出队、入队时的影响即可。
     *   出队：如果队列中存在元素，则执行出队操作，删除数组对应位置上的元素即可。由于数组在内存地址的连续
     * 性，导致每删除队列上的元素，都会造成数组内的元素移动。这个问题需要考虑。
     *        当队列中没有元素时，无法进行出队操作。
     *   入队：如果队列中存在剩余空间（tail 指针后面的空间），直接执行入队操作。
     * 如果队列已满，无法执行入队操作。那这个队列已满的条件是什么？对于第一种情况：head前面没有空间，tail 后面没有空间。
     *        第二种情况：tail 后面没有空间，head 前面存在空间。
     *
     * 问题：
     *   问题1: 每次出队都会导致数组内的元素进行移动以实现数组在内存地址中的连续性，这就把O(1) 复杂的度的
     * 出队，变成了O(n) 时间复杂度。常规的操作便是每一次出队都进行数组移动，我们则考虑在入队时，如果tail 没有空间时，再进行
     * 数组迁移操作。
     *   问题2: 如何判断数组实现的队列中没有剩余空间呢？落实到代码中，该如何判断呢？已知队列的容量n，head、tail 分别指向数组的下标，
     * 我们可以通过tail 指向的下标与数组的容量进行比较。如果tail == n 说明队列中已满。
     *   问题3: 如果判断数组实现的队列为空呢？只需判断head == n 即可。
     *
     * 伪代码：
     *     a.初始化队列容量n以及head、tail 分别指向的数组下标。
     *     b.入队时，检查队列是否存在剩余空间，执行入队操作。
     *     c.出队时，检查队列中是否存在元素，执行出队操作。
     *
     */

    private int head = 0;
    private int tail = 0;
    private int capacity;
    private String[] items;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
    }

    public boolean enter(String item){
        if(tail == capacity) return false;
        if(StringUtils.isEmpty(item)) return false;
        items[tail] = item;
        tail++;
        return true;
    }

    /*
     * v1 版本出队列方法中，每次出队中，都会触发数据迁移。会在v2 版本方法进行优化。
     */
    public String v1Out(){
        if(head == capacity) return  "";
        String headData = items[head];
        head++;
        //数据迁移
        for(int i = head; i < tail; i++){
            items[i-head] = items[i];
        }
        head = 0;
        tail--;
        items[tail] = null;
        return headData;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", capacity=" + capacity +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
