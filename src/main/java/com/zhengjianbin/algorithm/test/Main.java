package com.zhengjianbin.algorithm.test;

/**
 * Created by zhengjianbin on 2019/7/4.
 */
public class Main {

    public static void main(String[] args){
        int i = 0;
        test(i++);
        i++;
        System.out.println(test(i));
        //System.out.println(i);
    }

    public static int test(int i){
        System.out.println(i);
        return i;
    }

}
