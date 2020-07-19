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


####  分析 Queue 源码

在Java中Queue是继承接口Collection的一个接口。

添加元素方法：

`boolean add(E e);`

`boolean offer(E e);`

删除队列头部元素方法：

`E remove();`

`E poll();`

查看队列头部元素方法：

`E element();`

`E peek();`

其中，add、remove、element操作失败会抛出异常，而offer、poll、peek的操作是返回特殊值
