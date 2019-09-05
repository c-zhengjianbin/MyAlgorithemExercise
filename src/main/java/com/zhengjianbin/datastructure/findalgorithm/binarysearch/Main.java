package com.zhengjianbin.datastructure.findalgorithm.binarysearch;

/**
 * Created by zhengjianbin on 2019/9/5.
 */
public class Main {

    /**
     *
     * 思路：
     *    首先需要明确，二分查找的原理是什么？
     *    在有序数组中，每次与数组中指定区间内的中间元素进行比较，不断缩小区间范围，直到查到要找
     * 的元素。
     *    根据二分查找原理，需要在数组中找出中间元素，进行比较。然后选择左、右区间并选择区间内对应
     * 的进行比较，进行递归检查。在检查的过程中，我们需要借助两个变量，来划分指定的区间。一个重要的
     * 条件：我们该如何结束递归检查呢？当startIndex == endIndex 时，区间内只有一个元素，此时结
     * 束递归检查。还有一个需要注意的地方，就是在选择左、右区间时，如果对startIndex、endIndex进
     * 行赋值。需要明确的第一点是，中间元素即不属于左区间，也不属于右区间，对于startIndex = mid + 1，
     * endIndex = mid - 1。
     *
     * 伪代码：
     *     1、使用while进行元素检查，条件为startIndex < endIndex 。说明区间内有1个以上的元素。
     *     2、计算数组中间元素下标，使用变量midIndex = (startIndex + endIndex) / 2。
     *     3、获取中间下标对应的值，mid = 数组[midIndex]。
     *     4、比较mid 与提供的元素值是否一致，如果一致，return index。
     *     5、如果不一致，选点区间，根据所需区间，对startIndex 、endIndex 进行赋值，赋值原则
     * 为startIndex = midIndex + 1，endIndex = midIndex - 1。
     *
     *
     *
     */
    public static void main(String[] args){
        int[] testData = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        int findIndex = binarySearch(testData, 22);
        System.out.println(findIndex);
    }

    public static int binarySearch(int[] data, int findData){
        int index = -1;
        int startIndex = 0, endIndex = data.length - 1;
        if(startIndex == endIndex){
            return index;
        }
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            int midData = data[midIndex];
            System.out.println("获取到的midData:"+midData);
            //选择右区间
            if(findData > midData){
                startIndex = midIndex + 1;
            }else if (findData < midData){ //选择左区间
                endIndex = midIndex - 1;
            }else {
                index = midIndex;
                break;
            }
        }
        return index;
    }


}
