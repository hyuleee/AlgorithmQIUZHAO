# 学习笔记<br>
## 如何学习<br>
  1. 不要死磕，五毒神掌，死记硬背优秀代码<br>
  2. 区域化刻意练习<br>

## 数据结构<br>
  1.一维<br>
    a. 基础：array 数组；linked list 链表<br>
    b. 高级：stack 栈；queue 队列；deque 双端队列；set 集合；map 映射<br>
 <br>
  2. 二维<br>
    a. tree 树；graph 图<br>
    b. 二叉搜索树 （红黑树，AVL）；heap 堆；Trie 字典树； disjoint set 并查集<br>
  <br>
  3. 特殊<br>
    a. Bitwise 位运算; BloomFilter 布隆过滤器<br>
    b. LRU Cache 缓存<br>
  <br>


##   Queue 源码

Queue是继承接口Collection的一个接口。

添加元素方法：

`boolean add(E e);` 抛出异常

`boolean offer(E e);` 抛出特殊值

删除队列头部元素方法：

`E remove();`

`E poll();`

查看队列头部元素方法：

`E element();`

`E peek();`

## Priority Queue 的源码

Priority Queue的核心Heap，完全二叉树，构建通过heapify()函数，由一个n/2的非叶子节点循环和一个约为树高的logn遍历组成，所以时间复杂度为O(nlogn)。保证每次取出的都是权值最小的，元素的大小通过元素的自然顺序和构造时传入的比较器来判断。增加元素和删除已知数组下标的元素 O(logn)；删除一个未知下标的元素 O(n)

抽象类 AbstractQueue，实现Queue接口的add、remove、element方法，调用offer、poll、peek方法。不允许放入null元素，通过**完全二叉树实现的小顶堆**实现，底层通过**数组**实现。

## Week01刷题记录


| 题号                                                                                                                  | 名称                                                                            | 难度     | 分类         | 备注   | 次数    |
| ------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ------ | ---------- | ---- | ---- |
| [26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) | [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) | 🟢 简单  | 数组、链表、跳表  | -   |  1  |
| [21](https://leetcode.com/problems/merge-two-sorted-lists/discuss/?currentPage=1&orderBy=most_votes&query=)              | [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)                 | 🟢 简单  | 数组、链表、跳表  | -   |  1  |
| [42](https://leetcode.com/problems/trapping-rain-water/discuss/?currentPage=1&orderBy=most_votes&query=)                 | [接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)                         | 🔴️ 困难 | 栈、队列      | -   |  1  |
| [11](https://leetcode.com/problems/container-with-most-water/discuss/?currentPage=1&orderBy=most_votes&query=)      | [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)        | 🟡 中等  | 数组         | -    |  1  |
| [283](https://leetcode.com/problems/move-zeroes/discuss/?currentPage=1&orderBy=most_votes&query=)                   | [移动零](https://leetcode-cn.com/problems/move-zeroes/)                          | 🟢 简单  | 数组         | -    |  1  |
| [70](https://leetcode.com/problems/climbing-stairs/discuss/?currentPage=1&orderBy=most_votes&query=)                | [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)                      | 🟢 简单  | 数组         | -    |  1  |
| [15](https://leetcode.com/problems/3sum/discuss/?currentPage=1&orderBy=most_votes&query=)                           | [三数之和](https://leetcode-cn.com/problems/3sum/)                                | 🟡 中等  | 数组         | - |  1  |
| [1](https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=)                         | [两数之和](https://leetcode-cn.com/problems/two-sum/)                             | 🟢 简单  | 数组数组、链表、跳表 | 高频常考    |  1  |
| [141](https://leetcode.com/problems/linked-list-cycle/discuss/?currentPage=1&orderBy=most_votes&query=)             | [环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)                   | 🟢 简单  | 链表         | -    |  1  |
| [20](https://leetcode.com/problems/valid-parentheses/discuss/?currentPage=1&orderBy=most_votes&query=)              | [有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)                  | 🟢 简单  | 栈、队列       | -    |  1  |
| [155](https://leetcode.com/problems/min-stack/discuss/?currentPage=1&orderBy=most_votes&query=)                     | [最小栈](https://leetcode-cn.com/problems/min-stack/)                            | 🟢 简单  | 栈、队列       | -    |  1  |
| [84](https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/?currentPage=1&orderBy=most_votes&query=) | [柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/) | 🔴️ 困难 | 栈、队列       | -    |  1  |
| [239](https://leetcode.com/problems/sliding-window-maximum/discuss/?currentPage=1&orderBy=most_votes&query=)        | [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)           | 🔴️ 困难 | 栈、队列       | -    |  1  |
| [242](https://leetcode.com/problems/valid-anagram/description/)                                                     | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)       | 🟢 简单  | 哈希表、映射、集合  | -    |  1  |
| [189](https://leetcode.com/problems/rotate-array/discuss/?currentPage=1&orderBy=most_votes&query=)                       | [旋转数组](https://leetcode-cn.com/problems/rotate-array/)                               | 🟢 简单  | 数组、链表、跳表  | -   |  0  |
| [88](https://leetcode.com/problems/merge-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=)                  | [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)                     | 🟢 简单  | 数组、链表、跳表  | -   |  0  |
| [66](https://leetcode.com/problems/plus-one/discuss/?currentPage=1&orderBy=most_votes&query=)                            | [加一](https://leetcode-cn.com/problems/plus-one/)                                     | 🟢 简单  | 数组、链表、跳表  | -   |  0  |
| [641](https://leetcode.com/problems/design-circular-deque/discuss/?currentPage=1&orderBy=most_votes&query=)              | [设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)                  | 🟡 中等  | 栈、队列      | -   |  0  |
| [206](https://leetcode.com/problems/reverse-linked-list/discuss/?currentPage=1&orderBy=most_votes&query=)           | [反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)                 | 🟢 简单  | 链表         | -    |  0  |
| [24](https://leetcode.com/problems/swap-nodes-in-pairs/discuss/?currentPage=1&orderBy=most_votes&query=)            | [两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)           | 🟡 中等  | 链表         | -    |  0  |
| [142](https://leetcode.com/problems/linked-list-cycle-ii/discuss/?currentPage=1&orderBy=most_votes&query=)          | [环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)             | 🟡 中等  | 链表         | -    |  0  |
| [25](https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/?currentPage=1&orderBy=most_votes&query=)       | [K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)       | 🔴️ 困难 | 链表         | -    |  0  |
| [49](https://leetcode.com/problems/group-anagrams/)                                                                 | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)                   | 🟡 中等  | 哈希表、映射、集合  | -    |  0  |
