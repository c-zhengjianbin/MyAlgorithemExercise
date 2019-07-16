package com.zhengjianbin.algorithm.stringalgorithm.norepeatlongestsubstrlength;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengjianbin on 2019/7/4.
 */
public class Main {


    /**
     /**
     * 题目：
     *    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例1:
     *    输入: "abcabcbb"
     *    输出: 3
     *    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例2:
     *    输入: "bbbbb"
     *    输出: 1
     *    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例3:
     *    输入: "pwwkew"
     *    输出: 3
     *    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *    请注意，你的9答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 补充：子序列是不连续的字符串；子串是连续的字符串。
     */
    public static void main(String[] args){
        String str = "abjbez";
        int length = slidingWindow(str);
        System.out.println(length);
    }


    /**
     *
     * 思路：
     *    逐个检查所有的子串，是否存在重复的字符。
     *
     * 步骤：
     *    1.第一个for 循环负责从头开始检查。
     *    2.第二个for 循环负责从头开始检查的结束区间
     *    3.查看指定区间内的字符，是否有重复。如果没有重复，获取字符串长度。
     *
     * 解读：
     *    暴力循环检查
     */
    public static int violenceWay(String str){
        int result = 0;
        int length = str.length();
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j <= length; j++){
                if (uniqueStr(i, j, str)) result = Math.max(result, j - i);
            }
        }
        return result;
    }


    /**
     * 思路：
     *    使用暴力算法进行筛选，时间复杂度为O(n^3)，效果不是很理想。很有可能出现时间超时。在暴力
     * 算法中，我们判断字符串的每个子串是否包含重复字符，显然反复判断是没有必要的。那如何进行优化呢？
     *    我们引入滑动窗口对字符串进行检查。滑动窗口是数组/字符串问题中常用的抽象概念，窗口通常在数组/
     * 字符串中由开始和结束索引定义的一系列元素的集合，即[l, r)（左闭，右开）。也就是说，窗口实际上保存着
     * 一组数据，通过对这组数据的操作以达到某种目的。
     *    通过左右滑动，检查字符串中每个字符是否存在重复，如果不重复，就让它滑动。
     *
     * 步骤：
     *    1.创建保存窗口数据的容器。这里使用HashSet。
     *    2.定义窗口左、右指针。
     *    3.当左、右指针不超过字符串长度时，进行循环检查。
     *      a.判断字符是否在窗口中，如果存在，左边儿指针移动。
     *      b.如果不存在，移动右指针。说明目前窗口内的元素，无重复，计算长度。
     *
     * 补充：
     *    1.所谓的滑动本质上，是对窗口内的元素，进行取、舍。理解了这一点，set.remove(string.charAt(l++))
     * 代码就很理解了。它并不是把包含的元素去掉，而是将l 指针向右移动。因为以l 为起始的子串中，已经包含了重复
     * 字符。
     *
     * 总结：
     *    时间复杂度：比暴力方式低，为O(2n) = O(n)
     *    空间复杂度：楼主不会算，哈哈哈
     *
     *
     * //TODO 对滑动窗口进行优化
     */
    public static int slidingWindow(String string){
        Set<Character> set = new HashSet<>();
        int result = 0, l = 0, r = 0, length = string.length();
        while (l < length && r < length){
            if(!set.contains(string.charAt(r))){
                set.add(string.charAt(r++));
                result = Math.max(result, r - l);
            }else {
                set.remove(string.charAt(l++));
            }
        }
        return result;
    }

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/7/4 - 1:23 PM
     * @Param :
     * @function : 检查给定区间内的字符串是否出现重复字符
     */
    private static boolean uniqueStr(int start, int end, String str){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character c = str.charAt(i);
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

}
