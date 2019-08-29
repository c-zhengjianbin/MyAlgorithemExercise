package com.zhengjianbin.datastructure.sort.mergesort;

import java.util.Arrays;

/**
 * Created by zhengjianbin on 2019/8/26.
 */
public class Main {

    /**
     * 思路：
     *    首先需要明确，归并排序的原理是什么？
     *    归并排序是将一个未排序的数组，不断分前、后两部分。当无法继续分的时候，将前、后两部分的数组开始合并，
     * 最终达到排序的目的。
     *    通过原理我们可以将归并排序分为两步：拆分、合并。首先来看拆分，拆分就是结合数组的开始、结束下标，将
     * 数组不断拆分，直到无法拆分为止。递推公式为：arr(startIndex...endIndex) = arr(startIndex...midIndex) +
     * arr(midIndex + 1...endIndex)。当startIndex == endIndex 相等时，说明无法再分。为何当startIndex == endIndex
     * 时就无法再分呢？可以画图，当数组剩两个元素时，它的startIndex == endIndex 是相等的。
     *    接下来看合并，合并涉及的逻辑：
     *    1、考虑合并的条件是什么？无法再拆分时，进行合并。当，前数组下标 < 中间结点下标或后数组下标 <= 数组最后一个元素的下标。
     *    2、比较前、后数组元素的条件是什么？对于前数组，它的索引不能超过中间元素下标；并且对应下标的值，小于后数组值，
     * 这时把前数组的值写入临时数组。反之，把后数组的元素写入数组。
     *    3、当数组合并完后，把对应原数组下标对应的元素，替换为有序的。
     *
     * 伪代码：
     *    1、需要判断，当startIndex == endIndex 时，结束拆分数组。
     *    2、根据startIndex、endIndex 计算中间下标mid。
     *    3、递归调用mergeSort函数，对前、后数组进行拆分并合并。
     *    4、初始化临时数组，数组大小为startIndex ~ endIndex 之间的元素个数。size = endIndex - startIndex + 1；
     *    5、初始化leftIndex = startIndex, rightIndex = mid + 1，tempArrIndex。分别为前、后数组索引，临时数组
     * 索引。
     *    6、使用while 循环，进行数组合并。执行条件为，leftIndex <= mid || rightIndex <= endIndex。
     *    7、什么条件下将前数组的元素写入临时数组呢？条件为：leftIndex <= mid && (data[leftIndex] < data[right])
     * 还需要考虑后数组没有元素时，也就是rightIndex > endIndex。写入数据后，leftIndex++。以保证指向下一个元素。
     *    8、如果不满足条件，说明将后数组的元素写入临时数组。temp[tempArrIndex] = data[rightIndex]，写入数据后，
     * rightIndex++。
     *    9、无论是将前数组还是后数组的元素写入临时数组，都需要将tempArrIndex 进行++，为下次写入数据做准备。
     *    10、使用for循环，将data 对应下标的元素，替换为有序的。初始化条件为i = startIndex，结束条件为 i <= endIndex。
     *    11、data[i] = temp[i - startIndex]；在这里需要注意，由于startIndex 并不一定都是0，要保证在非0的状态下与临
     * 时数组的下标对应。因为temp 数组的元素都是从0开始。
     *
     */
    public static void main(String[] args){
        int[] testData = {3,2,1,5,4,30,14,25,6,60,25,19,33,22};
        mergeSort(testData, 0, testData.length - 1);
        System.out.println(Arrays.toString(testData));
    }

    public static void mergeSort(int[] data, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return;
        }
        int mid = (startIndex + endIndex ) / 2;
        mergeSort(data, startIndex, mid);
        mergeSort(data, mid + 1, endIndex);
        int[] tempArr = new int[endIndex - startIndex + 1];
        int leftIndex = startIndex, rightIndex = mid + 1, tempIndex = 0;
        while (leftIndex <= mid || rightIndex <= endIndex){
            //注意：在检查左边与右边数组的元素大小时，先要判断，右边是否有元素，不然会出现角标越界。
            if(leftIndex <= mid && (rightIndex > endIndex || data[leftIndex] < data[rightIndex])){
                tempArr[tempIndex] = data[leftIndex];
                leftIndex++;
            }else{
                tempArr[tempIndex] = data[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        for(int i = startIndex; i <= endIndex; i++){
            data[i] = tempArr[i - startIndex];
        }
    }

}
