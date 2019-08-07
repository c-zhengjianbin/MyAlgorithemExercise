package com.zhengjianbin.algorithm.arralgorithm.twosum;

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
     * TODO 隐患：无法解决数组中出现数字重复的问题 [2,7,7,15]。
     *
     *
     */
    public static void main(String[] args){
        int[] nums = new int[]{2, 5, 7, 11, 15};
        int[] result = useFirstMap(nums, 18);
        System.out.println(Arrays.toString(result));
    }

    /**
     *
     * 暴力遍历：
     *    遍历数组中每一个元素X，判断是否存在一个值与target - X 值相等。
     *
     * 备注：思路引自Leetcode 官网
     */
    public static int[] violenceWay(int[] nums, int target)throws  IllegalArgumentException{
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == (target - nums[j])){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("use violenceWay,two sum fail");
    }

    /**
     *
     * 使用两次Map：
     *    使用暴力遍历，时间复杂度为O(n^2)。复杂度为n^2 由于第二个for 循环导致。
     * 在查找时如果使用Map 则可将n^2 降至n 。需要注意，获取到的targetValue，不能是
     * 本身。
     *
     */
    public static int[] useSecondMap(int[] nums, int target)throws  IllegalArgumentException{
        Map<Integer, Integer> indexAndValue = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            indexAndValue.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++){
            int targetValue = target - nums[j];
            if(indexAndValue.containsKey(targetValue) && indexAndValue.get(targetValue) != j){
                return new int[]{j, indexAndValue.get(targetValue)};
            }
        }
        throw new IllegalArgumentException("use second map,two sum fail");
    }

    /**
     *
     * 使用一次Map：
     *    在使两次Map 时，一次是将全部元素添加至Map时。那能不能在添加的同时判断已存在的元素中，
     * 是否存在符合条件的索引呢？
     *
     * @return
     */
    public static int[] useFirstMap(int[] nums, int target)throws IllegalArgumentException{
        Map<Integer, Integer> indexAndValue = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int targetValue = target - nums[i];
            if(indexAndValue.containsKey(targetValue) && indexAndValue.get(targetValue) != i){
                return new int[]{i, indexAndValue.get(targetValue)};
            }
            indexAndValue.put(nums[i], i);
        }
        throw new IllegalArgumentException("use first map, compute two sum fail");
    }

}
