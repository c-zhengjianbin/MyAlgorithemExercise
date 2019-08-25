package com.zhengjianbin.datastructure.sort.selectsort;

import java.util.Arrays;

/**
 * Created by zhengjianbin on 2019/8/22.
 */
public class Main {

    /**
     * 思路：
     *   首先需要明确，选择排序的原理是什么？
     *   选择排序与插入排序极为类似，插入排序是在未排序元素中选择一个元素放到已排序中，当然需要在已排序中找到一个合适的位置。
     * 而选择排序是在未排序中选一个最小元素，放到已排序元素的末尾。注意它们的区别：插入排序是选未排序元素的第一个（默认情况下），
     * 而选择排序是选择未排序元素中最小的一个。
     *   这里涉及到一个问题：为维持数组内元素的有序性，如何找到一个最小元素后，把它放到已排序元素后，需要哪些步骤来配合呢？
     *
     * 步骤：
     *   1、在未排序元素中，找到一个最小元素，将它与未排序元素中第一个位置上的元素替换。因为未排序上的第一个元素，就在已排序
     * 元素的后面。
     *   2、下次进行查找最小元素时，会在刚刚最小元素后开始查找。
     *
     * 伪代码：
     *   1、获取数组的一个元素，让它与剩下的元素进行比较。通过for 语法来实现，它的初始化条件为i = 0，表示这次拿数组[0]的元素与
     * 其他元素进行比较，退出条件为 i < 数组内元素大小。
     *   2、进行比较。比较通过for 循环来实现，比较从获取到数组的一个元素后面的元素开始，初始化条件为j = i+1，退出条件为j < 数
     * 组内元素的大小。
     *   3、在比较过程中，如果找到最小值则进行替换。替换原则为步骤1 提到的逻辑。
     *   4、如果找到最小值，记录最小值的索引。
     */
    public static void main(String[] args){
        int[] testData = {3,2,1,5,4};
        int[] result = selectSort(testData);
        System.out.println(Arrays.toString(result));
    }

    public static int[] selectSort(int[] data){
        int size = data.length;
        for(int i = 0; i < size; i++){
            int minIndex = i;
            // j < size - 1，是把比较的元素剔除
            for(int j = i + 1; j < size; j++){
                if(data[i] > data[j]){
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        return data;
    }

}
