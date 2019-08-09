package com.zhengjianbin.datastructure.linknode.linknodereverse;

import com.zhengjianbin.algorithm.linkedlistalgorithm.twoadd.LinkNode;

/**
 * Created by zhengjianbin on 2019/8/9.
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        LinkNode linkNode = new LinkNode(1);
        linkNode.setNext(new LinkNode(2).setNext(new LinkNode(3)));
        LinkNode reverseNode = reverseNode(linkNode);
        while (reverseNode != null) {
            System.out.println(reverseNode.getValue());
            reverseNode = reverseNode.getNext();
        }
    }

    /**
     * 思路1：
     *    采用非递归。
     *    反转链表，实际是将结点的next 设置成前面的结点。以A->B->C 为例，实际
     * 上是指将A的next 设置为null，B的next 设置为A，C的next 设置为B。
     *    如果我们上来就把A的next 设置成null，链表就断了，无法正常遍历，因为此时B = null。
     *  我们需要一个临时变量temp 来存储A 的next。然后设置A.next = null。从例子中我们看出，
     *  A.next = null，是因为前一个结点不存在，那对于B 来说，是存在前驱结点，这样B.next = A。
     *  所以我们需要一个变量来保存前驱结点，这样在设置A.next = pre时非常方便。
     *
     * 伪代码：
     *    1.判断结点是否为空或者下一个结点为空。
     *    2.将pre、next 结点初始化为null。
     *    3.遍历结点：
     *            a.使用next 变量保存当前节点的next
     *            b.设置当前的next 为前驱结点
     *            c.设置前驱结点为当前节点
     *            d.将当前节点设置为 当前节点的next结点。
     *
     * 问题1：
     *    每个结点反转后，原来的结点结构发生了怎样的变化？
     *
     * 回答1：
     *    由于head 上的结点，在将head.next 结点交给next 变量保存并设置null后。和前一个结点已经
     * 断了联系。当执行完最后一个结点时，head 上已经没有了结点。（当然每个结点对象还是在内存中的）
     *    新的结点都会重新依附到pre 结点上。每次执行完后，都会把pre 上的结点放到head 当前
     * 结点上，再把结点赋值到pre 结点上，以实现链表反转。
     *
     */
    public static LinkNode reverseNode(LinkNode head) throws CloneNotSupportedException {
        if(head == null || head.getNext() == null){
            return head;
        }
        LinkNode pre = null;
        LinkNode next;
        while(head != null){
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

}
