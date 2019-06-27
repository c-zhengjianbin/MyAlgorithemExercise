package com.zhengjianbin.algorithm.twosum;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengjianbin on 2019/6/27.
 */
public class Main {

    /**
     *
     * 题目：
     *    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     *    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *    示例：给定 nums = [2, 7, 11, 15], target = 9，
     *         因为 nums[0] + nums[1] = 2 + 7 = 9所以返回 [0, 1]
     * @param args
     */
    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = useTwoMap(nums, 18);
        System.out.println(Arrays.toString(result));
    }

    /**
     *
     * 暴力遍历：
     *    遍历数组中每一个元素X，判断是否存在一个值与target - X 值相等。
     *
     * 备注：思路引自Leetcode 官网
     */
    public static int[] violenceWay(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == (target - nums[j])){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     *
     * 使用两次Map：
     *    使用暴力遍历，时间复杂度为O(n^2)。复杂度为n^2 由于第二个for 循环导致。
     * 在查找时如果使用Map 则可将n^2 降至n 。
     *
     */
    public static int[] useTwoMap(int[] nums, int target){
        Map<Integer, Integer> indexAndValue = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            indexAndValue.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++){
            int targetValue = target - nums[j];
            if(indexAndValue.containsKey(targetValue)){
                return new int[]{j, indexAndValue.get(targetValue)};
            }
        }
        return new int[]{};
    }

}
