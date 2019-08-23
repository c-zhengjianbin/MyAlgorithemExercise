package com.zhengjianbin.datastructure.sort.insertsort;

import java.util.Arrays;

/**
 * Created by zhengjianbin on 2019/8/22.
 */
public class Main {

    /**
     * 思路：
     *    首先需要明确，插入排序的原理是什么？
     *    对于插入排序，它分为两部分：已排序部分、未排序部分。每次选区未排序部分的数据，将它插入到
     * 已排序部分。这里需要注意：如何正确的插入到已排序部分，是重点。
     *    针对一个大小为n 的数组，需要n - 1 次从未排序部分拿出一个元素，放到已排序部分。而放到已
     * 排序的过程，又是一次比较。所以整体的时间复杂度为O(n^2)。
     *    虽然插入排序原理上分为已排、未排序部分，但是我们不会借助存储空间，存储已排序、未排序部分。
     * 只是从逻辑上分为已排、未排序部分。
     *    那我们如何把数据插入到已排序部分，它的逻辑是怎样呢？
     *    数据插入分为两步：寻找插入数据在数组中的位置；插入数据。
     *    由于数组的特性，需要考虑一点，插入数据后，要保证数组内部的连续性，这里涉及到数据的迁移。
     *    对于数据迁移，有两种思路：第一种，寻找位置过程中，不进行数据迁移，找到位置到再进行迁移。
     * 第二种一边找位置，一边儿迁移数据。我们选择第二种，因为找到位置后，数据也移动完成，然后直接写入
     * 数据即可。
     *
     * 伪代码：
     *    a.从未排序部分拿出一个元素，我们通过for 循环语法，初始条件为：i = 1，将第一个数据当成
     * 已排序部分的元素。退出条件为 n - 1。
     *    b.使用变量value保存未排序元素的一个元素。
     *    c.使用变量j 保存要插入的位置。
     *    b.将取出的元素，放入已排序元素中。我们从后往前寻找位置，寻找位置通过for 循环语法，初始条件为j = i，
     * 退出条件为 j >= 0; j--。此循环查找插入数据位置。
     *    c.找到合适位置到，插入数据。
     *
     */
    public static void main(String[] args){
        int[] testData = {3,2,1,5,4};
        int[] result = insertSort(testData);
        System.out.println(Arrays.toString(result));
    }

    public static int[] insertSort(int[] data){
        int size = data.length;
        for(int i = 1; i < size; i++){
            int value = data[i];
            int j = i - 1;
            //在已排序元素中查找位置
            for(; j >= 0; j--){
                if(data[j] > value){
                    //数据移动，实质为交换数据。
                    data[j+1] = data[j];
                }else {
                    break;
                }
            }
            //j + 1，保证了在经历了j--后，找到正确的位置。
            data[j+1] = value;
        }
        return data;
    }

}
