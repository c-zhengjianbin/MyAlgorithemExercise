package com.zhengjianbin.datastructure.sort.quicksort;

import java.util.Arrays;

/**
 * Created by zhengjianbin on 2019/9/3.
 */
public class Main {

    /**
     * 思路：
     *   首先需要明确，快速排序的原理是什么？
     *   给定一个未排序的数组，在开始下标s、结束下标e 之间任选一个元素pivot，遍历s ~ e 之间的元素，小于
     * pivot 的元素放到pivot 左边，大于pivot 的元素放到右边，遍历结束后使得：左边都是小于pivot 的元素，
     * 右边都是大于pivot 的元素。使用递归不断对左、右两边元素采用上述逻辑进行比较，左、右两边元素无法递
     * 归时，结束。那结束递归的条件是什么？当s >= e 时，退出递归。（如果不理解s >= e时，为何就退出递归，
     * 可以把图处理。）
     *   我们来解读一下上述原理。可以看出，快速排序包含两步操作：选出pivot 元素并将它放到合适位置；对左、右两边
     * 元素进行递归检查。快速排序与归并排序类似，采用分治思想解决问题。我们先写出它的递推公式：
     * quickSort(s...e)=quickSort(s, pivotIndex -1) + quick(pivotIndex + 1, e)。可以看出，对于左、右
     * 两边递归调用比较简单。难点在于选出pivot 元素并将它放到合适的位置。一旦涉及将元素放到数组中指定的位置，
     * 就需要移动数组内的数据，以实现数组内数据的连续性。整个操作下来时间复杂度为O(n^2)，通过使用替换方式，将
     * 时间复杂度降至O(1)。
     *   我们将数组中最后一个元素选为pivot。其次将数组内元素进行划分，分为已处理、未处理。区域的划分，并不使用格
     * 外的数组进行存储，那样快速排序的空间复杂度会上升。所谓的划分只是逻辑上的划分，指定下标内的元素为已处理，下
     * 标外的元素为未处理。划分处理方式有点像选择排序，第一个元素下标默认已处理，第二个元素以后为未处理。
     *   使用一个变量i，将数组分成两部分，数组[s-(i-1)]为已处理部分，数组[i+1,e] 为未处理部分。我们在s ~ e之
     * 间选一个元素数组[j]，与pivot 比较。如果比pivot 小，则加入到已处理区间，i++，表示已处理。如果比pivot大,
     * 移动变量j移动。
     *
     * 伪代码：
     *    1、检查传入的startIndex、endIndex，当startIndex >= endIndex时，结束递归。
     *    2、将数组最后一个元素，定义为pivot 数值。
     *    3、定义变量i表示pivot 合适的位置，为数组分区做准备。将数组开始下标startIndex，赋值到i = startIndex。
     *    4、使用for循环，准备检查startIndex与endIndex 之间的元素，初始化变量j = startIndex，
     * 结果条件为endIndex - 1。
     *    *5、如果数组[j] < pivot ，说明需要处理，将i = j 的元素进行互换。
     *    6、循环结束后，说明已经找到合适的pivot 合适的位置。将它与i 的值进行替换。
     *
     * 注意：
     *    1、在递推公式中，为何是quickSort(s,pivotIndex - 1) 、quickSort(pivotIndex + 1) ？而不是(s, pivotIndex)、
     * (pivotIndex + 1, e)呢？
     *    --回答：因为pivot 元素既不属于左边也不属于右边。在进行递归时，需要将pivot 对应的index 剔除。左边通过减1，右边
     * 通过加1 来实现。
     */
    public static void main(String[] args){
        int[] testData = {3,2,1};
        quickSort(testData, 0, testData.length - 1);
        System.out.println(Arrays.toString(testData));
    }

    public static void quickSort(int[] data,int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = partition(data, startIndex, endIndex);
        quickSort(data, startIndex, pivotIndex - 1);
        quickSort(data, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] data,int startIndex, int endIndex){
        int pivot = data[endIndex];
        int i = startIndex;
        for(int j = startIndex; j <= endIndex - 1; j++){
            if(data[j] < pivot){
                swap(data, i, j);
                i++;
            }
        }
        swap(data, i, endIndex);
        return i;
    }

    public static void swap(int[] data, int oldIndex, int newIndex){
        int temp = data[oldIndex];
        data[oldIndex] = data[newIndex];
        data[newIndex] = temp;
    }

}
