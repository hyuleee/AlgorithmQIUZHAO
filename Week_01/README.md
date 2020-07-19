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


####   Queue 源码

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

#### Priority Queue 的源码

Priority Queue的核心Heap，完全二叉树，构建通过heapify()函数，由一个n/2的非叶子节点循环和一个约为树高的logn遍历组成，所以时间复杂度为O(nlogn)。保证每次取出的都是权值最小的，元素的大小通过元素的自然顺序和构造时传入的比较器来判断。增加元素和删除已知数组下标的元素 O(logn)；删除一个未知下标的元素 O(n)

抽象类 AbstractQueue，实现Queue接口的add、remove、element方法，调用offer、poll、peek方法。不允许放入null元素，通过**完全二叉树实现的小顶堆**实现，底层通过**数组**实现。

