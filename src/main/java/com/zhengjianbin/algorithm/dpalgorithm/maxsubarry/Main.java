package com.zhengjianbin.algorithm.dpalgorithm.maxsubarry;

/**
 * Created by zhengjianbin on 2019/7/16.
 */
public class Main {

    /**
     *
     *
     * 题目：
     *    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和。
     *
     * 示例：
     *    输入：[-2, 1, -3, 4, -1, 2, 1, -5, 4]
     *    输出：6
     *    例如：连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     */
    public static void main(String[] args){

    }

    /**
     * 思路：
     *    既然是返回最大连续子序列的最大和。那我们要思考，在什么条件下，
     * 返回的最大连续子序列是最大的？
     *    第一：在子序列对下一个元素相加前，它的值一定要大于 0。不然下一个元素是
     * 多大值都没用，因为前面的负数，会在相加后，把这个和拉小。
     *    第二：只有当值大于0 时，对下一个元素相加才有意义。当和大于0 时，后面的
     * 元素为负数也没关系，一定要保证子序列在添加下一个元素时，值大于0 。
     *
     * 伪代码：
     *
     *
     *
     */
    public static int maxsubarry(int[] nums){

        return 0;
    }

}
