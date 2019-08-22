package com.zhengjianbin.datastructure.sort.bubblesort;

import java.util.Arrays;

/**
 * Created by zhengjianbin on 2019/8/21.
 */
public class Main {

    /**
     * 思路：
     *    首先需要明确，冒泡排序的原理是什么？
     *    对于冒泡排序，它每一次依次比较两个相邻的元素，如果满足大小条件，进行移动。在每一次的比较后，
     * 会出现一个最大的数。
     *    对于一个n 大小的数组，它需要n 个每一次，才能将数组排序好。而每一次的依次比较两个相邻元素大小，
     * 又是一个O(n) 的操作。所以冒泡排序是一个O(n^2) 的时间复杂度算法。
     *
     * 伪代码：
     *    a.为了保证n个每一次，需要借助于for 循环。它的退出条件为n-1
     *    b.接下来是每一次内的依次比较两个相邻元素，同样借助for 循环。由于在内部，它的初始化条件为0，以
     * 保证内部都头开始比较相邻的元素。它的退出条件需要简单思考一下：由于在每一次执行完后，都会生成一个最大数，
     * 而这个最大数，无需参与比较。最终退出条件为 n - (第几个每一次) - 1
     *    c.如果每一次内部的相邻元素符合条件，进行移动。
     *    d.检查内部相邻元素比较时，是否出现移动，如果没有，说明数组是已有序的。直接结束外面的每一次比较。
     */
    public static void main(String[] args){
        int[] testData = {3,2,1,5,4};
        int[] result = sort(testData);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] data){
        int dataSize = data.length;
        for(int i = 0; i < dataSize - 1; i++){
            boolean isSwap = false;
            for(int j = 0; j < dataSize - i - 1; j++){
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
        return data;
    }

}
