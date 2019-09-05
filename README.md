# MyAlgorithemExercise

## 项目介绍
* ### ☘️介绍
     * 基于LeetCode 提供的练习题，记录题目、解决思路、遇到的问题。
     * 结合官网提供的思路进行思考，将其转换成代码。
     * 记录解决思路与官方思路存在的差异。
     * 记录解决问题时，遇到的坑。
        
* ### ☘️目的
     * 提高算法能力。写出稳健、高效的代码。
     * 提高抽象、逻辑能力。设计出靠谱的业务逻辑。 
     
* ### ☘️算法摘要
     * 数组类型
        * [两数求和](src/main/java/com/zhengjianbin/algorithm/arralgorithm/twosum/Main.java)
        * [三数之和](src/main/java/com/zhengjianbin/algorithm/arralgorithm/threesum/Main.java)     
     * 动态规划
        * [数组中最大连续序列求和](src/main/java/com/zhengjianbin/algorithm/dpalgorithm/maxsubarry/Main.java)
     * 链表类型
        * [两数相加](src/main/java/com/zhengjianbin/algorithm/linkedlistalgorithm/twoadd/Main.java)
        * [回文链表判断](src/main/java/com/zhengjianbin/algorithm/linkedlistalgorithm/ispalindrome/Main.java)
     * 栈类型
        * [检查括号正确性](src/main/java/com/zhengjianbin/algorithm/stackalgorithm/bracketvaild/BracketVaild.java)
     * 字符串类型
        * [求字符串中最大子串长度](src/main/java/com/zhengjianbin/algorithm/stringalgorithm/norepeatlongestsubstrlength/Main.java)
     * 队列类型
        * [求3秒内的请求数量](src/main/java/com/zhengjianbin/algorithm/queuealgorithm/getrecentreqcounter/Main.java)
     * 多线程类型
         * [按序打印](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/inorderprint/Main.java)
            * [解法1](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/inorderprint/Foo.java)
            * [解法2](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/inorderprint/FooUseCountDownLatch.java)
         * [交替打印](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/alternatelyprint/Main.java) 
            * [解法](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/alternatelyprint/FooBar.java)
         * [打印零奇数偶数](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/printzerooddeven/Main.java)
            * [解法](src/main/java/com/zhengjianbin/algorithm/multithreadalgorithm/printzerooddeven/ZeroOddEven.java)

* ### ☘️涉及Java 类文档翻译
     * 多线程
       * [Semaphore](src/main/java/com/zhengjianbin/translation/multithread/Semaphore.md)
       * [CountDownLatch](src/main/java/com/zhengjianbin/translation/multithread/CountDownLatch.md)
       

* ### ☘️数据结构打靶场
     * 链表类型
       * [单链表反转](src/main/java/com/zhengjianbin/datastructure/linknode/linknodereverse/Main.java)
       * [求链表中间结点](src/main/java/com/zhengjianbin/datastructure/linknode/linknodemiddle/Main.java)
     * 队列类型
       * [数组实现队列](src/main/java/com/zhengjianbin/datastructure/queue/arrqueue/ArrayQueue.java)
       * [链表实现队列](src/main/java/com/zhengjianbin/datastructure/queue/linknodequeue/LinkNodeQueue.java)
       * [实现循环队列](src/main/java/com/zhengjianbin/algorithm/queuealgorithm/circularqueue/Main.java)
     * 排序算法
       * [冒泡排序](src/main/java/com/zhengjianbin/datastructure/sort/bubblesort/Main.java)
       * [插入排序](src/main/java/com/zhengjianbin/datastructure/sort/insertsort/Main.java)
       * [选择排序](src/main/java/com/zhengjianbin/datastructure/sort/selectsort/Main.java)
       * [归并排序](src/main/java/com/zhengjianbin/datastructure/sort/mergesort/Main.java)
       * [快速排序](src/main/java/com/zhengjianbin/datastructure/sort/quicksort/Main.java)
     * 查找算法
       * [二分查找](src/main/java/com/zhengjianbin/datastructure/findalgorithm/binarysearch/M``ain.java)
        
* ### ☘️项目结构
     * 项目结构与包名注释🌴（题目、解题思路在Main.java中）。
     ```          
     ├── algorithm
     │   ├── MyalgorithemexerciseApplication.java
     │   ├── arralgorithm-----数组类型算法
     │   │   ├── other
     │   │   ├── threesum
     │   │   │   └── Main.java
     │   │   └── twosum
     │   │       └── Main.java
     │   ├── dpalgorithm-----动态规划类型算法
     │   │   ├── 0、动态规划简介.md
     │   │   └── maxsubarry
     │   │       └── Main.java
     │   ├── linkedlistalgorithm-----链表型算法
     │   │   ├── ispalindrome
     │   │   │   └── Main.java
     │   │   └── twoadd
     │   │       ├── LinkNode.java
     │   │       └── Main.java
     │   ├── multithreadalgorithm-----多线程算法
     │   │   ├── alternatelyprint
     │   │   │   ├── FooBar.java
     │   │   │   └── Main.java
     │   │   ├── inorderprint
     │   │   │   ├── Foo.java
     │   │   │   ├── FooUseCountDownLatch.java
     │   │   │   └── Main.java
     │   │   └── printzerooddeven
     │   │       ├── Main.java
     │   │       └── ZeroOddEven.java
     │   ├── queuealgorithm-----队列型算法
     │   │   ├── circularqueue
     │   │   │   ├── CircularQueue.java
     │   │   │   └── Main.java
     │   │   └── getrecentreqcounter
     │   │       ├── Main.java
     │   │       └── RecentCounter.java
     │   ├── stackalgorithm-----栈表型算法
     │   │   └── bracketvaild
     │   │       ├── BracketVaild.java
     │   │       └── Main.java
     │   ├── stringalgorithm-----字符串型算法
     │   │   ├── longestpalindrome
     │   │   │   └── Main.java
     │   │   └── norepeatlongestsubstrlength
     │   │       └── Main.java
     │   └── test
     │       └── Main.java
     ├── datastructure
     │   ├── linknode
     │   │   ├── linknodemiddle
     │   │   │   └── Main.java
     │   │   └── linknodereverse
     │   │       └── Main.java
     │   ├── queue
     │   │   ├── Main.java
     │   │   ├── arrqueue
     │   │   │   └── ArrayQueue.java
     │   │   └── linknodequeue
     │   │       └── LinkNodeQueue.java
     │   └── sort
     │       ├── bubblesort
     │       │   └── Main.java
     │       ├── insertsort
     │       │   └── Main.java
     │       └── selectsort
     │           └── Main.java
     └── translation
         └── multithread
             └── Semaphore.md
     ```  