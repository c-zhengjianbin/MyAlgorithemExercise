package com.zhengjianbin.algorithm.arralgorithm.threesum;

import java.util.*;

/**
 * Created by zhengjianbin on 2019/8/7.
 */
public class Main {

    /**
     *
     * 题目：
     *    给定一个包含n 个整数的数组nums ，判断nums 中是否存在三个元素：a，b, c，使得
     * a + b + c = 0。找出所有满足条件且不重复的三元组。
     *
     * 示例：
     *    给定数组 nums = [-1, 0, 1, 2, -1, 4]
     *    满足要求的三元组集合为：[
     *      [-1, 0, 1]
     *      [-1, -1, 2]
     *    ]
     *
     * 注意：答案中不可以包含重复的三元组
     *
     */
    public static void main(String[] args){
        int[] testData = new int[]{-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = violenceThreeSum(testData);
        System.out.println(result);
    }

    /**
     *
     * 解题：
     *    首先从题意看出，找出满足条件且不重复的三元组。这意味着，[-1, 0, 1]、[1，0, -1]属于
     * 一个三元组。这跟之前输出结果不一样。
     *    换句话说，从这个数组里，选出三个元素，相加等于0。但是每个元组内，不能重复。
     *
     * 思路：
     *    暴力破解
     *    先使用最简单的方式，对数组内的每个元素进行循环遍历。
     *
     * 问题1：
     *    出现了重复问题。如何解决？
     *    重复是由于元组内的元素无序导致，如果在保证有序的情况下。添加之前，使用API 检查一下即可。
     * 如果不排序，使用API 检查失败。
     *
     * 问题2：
     *    TODO 时间复杂度为O(n^3) 待优化。
     *
     */
    public static List<List<Integer>> violenceThreeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int numsLen = nums.length;
        for(int i = 0; i < numsLen - 2; i++){
            for(int j = i +1; j < numsLen - 1; j++){
                for(int z = j + 1; z < numsLen; z++){
                    if((nums[i] + nums[j] + nums[z]) == 0){
                        //去重复
                        List<Integer> data = Arrays.asList(nums[i], nums[j], nums[z]);
                        List<List<Integer>> resultTemp = Arrays.asList(data);
                        if(!result.containsAll(resultTemp)){
                            result.add(data);
                        }
                    }
                }
            }
        }
        return result;
    }


}
