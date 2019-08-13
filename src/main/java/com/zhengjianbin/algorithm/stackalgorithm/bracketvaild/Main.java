package com.zhengjianbin.algorithm.stackalgorithm.bracketvaild;

/**
 * Created by zhengjianbin on 2019/8/13.
 */
public class Main {


    /**
     * 题目：
     *    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *    有效字符串需满足：
     *       a.左括号必须用相同类型的右括号闭合。
     *       b.左括号必须以正确的顺序闭合。
     *       c.注意空字符串可被认为是有效字符串。
     * 示例1：
     *    输入: "()"
     *    输出: true
     *
     * 示例2：
     *    输入: "()[]{}"
     *    输出: true
     *
     * 示例3：
     *    输入："(]"
     *    输出：false
     *
     * 示例4：
     *    输入："([)]"
     *    输出：false
     *
     * 示例5：
     *    输入："{[]}"
     *    输出：true
     *
     */
    public static void main(String[] args){
        BracketVaild bracketVaild = new BracketVaild();
        System.out.println(bracketVaild.isVaildChar("[{()}(([])]}"));
    }



}
