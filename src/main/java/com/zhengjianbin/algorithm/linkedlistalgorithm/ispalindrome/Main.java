package com.zhengjianbin.algorithm.linkedlistalgorithm.ispalindrome;

import com.zhengjianbin.algorithm.linkedlistalgorithm.twoadd.LinkNode;

import java.util.Stack;

/**
 * Created by zhengjianbin on 2019/8/8.
 */
public class Main {

    /**
     * 题目：
     *    请判断一个链表是否为回文链表。
     *
     * 示例1：
     *    输入：1->2
     *    输出：false
     *
     * 示例2：
     *    输入：1->2->2->1
     *    输出：true
     *
     */
    public static void main(String[] args){
        LinkNode linkNode = new LinkNode(1);
        linkNode.setNext(new LinkNode(2).
                        setNext(new LinkNode(3).
                                setNext(new LinkNode(6).
                                        setNext(new LinkNode(3).
                                                setNext(new LinkNode(2).
                                                        setNext(new LinkNode(1)))))));
        System.out.println(isPalindrome(linkNode));
    }

    /**
     * 思路1：
     *    借助单链表、快慢指针、栈。
     *    通过快慢指针定位链表中间节点，慢节点移动一步、快节点移动两步。（不理解的同学可以在纸上画图，楼主开始也不理解快慢节点
     *    究竟是如何定位中间节点的。画上图，一目了然。）
     *    使用栈保存中间（包括中间节点）节点及之前的数值。通过比较栈中的元素与中间节点后面的元素，检查是否为回文链表。
     *    需要注意，当链表大小为奇、偶数时，需要进行操作栈内的元素。奇数时，POP出中间结点。偶数时，无需POP。
     *
     * 伪代码：
     *    1.将慢、快节点初始化为当前Head节点。
     *    2.当fast.next 和fast.next.next 节点为空时，说明找到中点节点。
     *    3.检查fast 是否为尾结点。如果不是，POP 中间节点。（元素个数为偶数）
     *    4.移动慢指针与栈内的元素值进行比较。
     *    
     * 复杂度：
     *    时间复杂度为O(n)，空间复杂度为(n/2)
     */
    public static boolean isPalindrome(LinkNode head){
        LinkNode slow = head, fast = head;
        Stack<Integer> slowVal = new Stack<>();
        slowVal.push(head.getValue());
        while (fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            slowVal.push(slow.getValue());
        }
        if(fast.getNext() == null){
            slowVal.pop();
        }
        while(slow.getNext() != null){
            slow = slow.getNext();
            int nextVal = slow.getValue();
            int stackVal = slowVal.pop();
            if(stackVal != nextVal){
                return false;
            }
        }
        return true;
    }


}
