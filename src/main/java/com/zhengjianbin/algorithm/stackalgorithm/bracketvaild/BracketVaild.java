package com.zhengjianbin.algorithm.stackalgorithm.bracketvaild;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhengjianbin on 2019/8/13.
 */
public class BracketVaild {

    private Map<Character, Character> leftCharAndRightChar = new HashMap<>();

    public BracketVaild() {
        leftCharAndRightChar.put(')','(');
        leftCharAndRightChar.put('}','{');
        leftCharAndRightChar.put(']','[');
    }


    /**
     * 思路：
     *   从左到右，遍历字符串。当遇到左相关的符号时，将其推入栈。匹配到右相关符号时，
     * 弹出栈顶元素，进行比较。
     *
     * 伪代码：
     *     a.遍历字符串s
     *     b.检查是否为左字符，是的话压入栈。
     *     c.检查是否为右字符，是的弹出栈，进行比较。
     *     d.如果栈为空，返回特定的字符串。否和弹出栈顶元素。
     *     d.如果栈中的元素为空，说明符合条件；剩余元素，说明匹配失败。
     */
    public boolean isVaildChar(String s){
        Stack<Character> leftChars = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            if(!leftCharAndRightChar.containsKey(charS)){
                leftChars.push(charS);
            }else {
                char leftCharStack = leftChars.empty() ? '#' : leftChars.pop();
                if(leftCharStack != this.leftCharAndRightChar.get(charS)){
                    return false;
                }
            }
        }
        return leftChars.isEmpty();
    }

}
