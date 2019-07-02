package com.zhengjianbin.algorithm.twoadd;

/**
 * Created by zhengjianbin on 2019/7/2.
 */
public class Main {

    /**
     * 题目：
     *    给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式
     * 存储的，并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返
     * 回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *    输出：7 -> 0 -> 8
     *    例如：342 + 465 = 807
     *
     */
    public static void main(String[] args){
        LinkNode firset = new LinkNode(2);
        firset.setNext(new LinkNode(4).setNext(new LinkNode(3)));
        LinkNode second = new LinkNode(5);
        second.setNext(new LinkNode(6).setNext(new LinkNode(4)));
        System.out.println(1);
        LinkNode result = twoLinkNodeAdd(firset, second);
        System.out.println(2);
    }

    /**
     * 思路：
     *    1、对于两个0~9 的数字进行相加，最大不会超过20。使用变量跟踪进位（也就是相加超过10），
     * 并从最低位有效位进行相加。进位的变量参与下一次运算。
     *    2、carry 作为进位的变量，它的取值范围会是什么？只有0、1。上面说过，数字相加不会超过20，
     * 最大无非是9 + 9 + 1（进位值）= 19。
     *
     * 伪代码：
     *    1、创建Result结点，用两个变量表示firstLinknode、secondLinknode 的头结点
     *    2、初始化carry 值。
     *    3、遍历firstLinknode、secondLinknode直到它们的尾部。
     *       3.1、使用两个变量保存当前结点的值，x 表示firstLinknode 节点的值，y 表示secondLinknode 节点的值
     *       3.2、sum = x + y + carry
     *       3.3、检查sum 是否需要进位，sum / 10
     *       3.4、将sum 保存到一个新的节点 new LinkNode(sum % 10)
     *       3.5、将下一个节点，设置为当前结点
     *       3.6、移动变量，指向firstLinknode、secondLinknode下一个节点
     *    4、如果遍历完后，发现carry 为1，需要创建结点，保存此元素。
     *
     */
    public static LinkNode twoLinkNodeAdd(LinkNode firstLinknode, LinkNode secondLinknode){
        LinkNode result = new LinkNode(0);
        LinkNode p = firstLinknode, q = secondLinknode, curr = result;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.getValue() : 0;
            int y = (q != null) ? q.getValue() : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.setNext(new LinkNode(sum % 10));
            curr = curr.getNext();
            //当p、q 为null 时，后面没有结点
            if(p != null){
                p = p.getNext();
            }
            if(q != null){
                q = q.getNext();
            }
        }
        if(carry > 0){
            curr.setNext(new LinkNode(carry));
        }
        return result.getNext();
    }

}
