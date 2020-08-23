## 学习笔记

### 平衡二叉树
##### AVL树 由于查询时间复杂度是等于树的深度，所以需要平衡二叉树 但节点需要额外存储额外信息，且调整次数频繁
四种旋转操作 平衡因子bf = {-1, 0, 1}

##### 红黑树 近似平衡二叉树 确保左右子树高度差小于两倍 不能有相邻的红色结点

##### AVL 红黑树对比
    AVL树提供更好的查询，因为其更加严格平衡
		红黑树提供更快的插入删除操作，因为AVL旋转操作更多
		AVL要存的额外信息更多（高度和平衡因子），需要更多的内存，红黑树只需要一个Bit存红黑，对额外空间的消耗更小
		综合：在读操作多，写操作很少的时候采用AVL（database），在写操作多的时候用红黑树（map, set库）

### 位运算 或| 与& 反~ 异或^（同为0不同为1）

1. 判断奇偶：
  x % 2 ==1 -> x & 1 == 1
  x % 2 ==0 -> x & 1 == 0
2. 清零最低位1
  x & (x - 1)
3. 得到最低位1
  x & -x

### 字典树 最大限度减少字符串比较

**代码模板**


```
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}


```
### 并查集 组团、匹配问题

**代码模板**


```
class UnionFind{
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
//            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int count(){
            return count;
        }



    }

```

### 双向BFS代码模板


```

        // 总访问数组
        Set<String> visited = new HashSet<>();
        
        //左右哈希表双向BFS
        Set<String> beginSet = new HashSet<>();

        Set<String> endSet = new HashSet<>();
        int step = 1;
        
        while(!endSet.isEmpty() && !beginSet.isEmpty()) {
            //采用较小的开始扩散
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for () {
                        if () {                   // 根据具体题目要求
                            if () return step + 1; 
                            if (!visited.contains(nextWord)) {
                                nextLevel.add();
                                visited.add();
                            }
                        }  
                }
            }
            beginSet = nextLevel;
            step++;
        }



```




### Week05刷题记录


| 题号                                                                                                                  | 名称                                                                            | 难度     | 分类         | 备注   | 次数    |
| ------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ------ | ---------- | ---- | ---- |
| [52](https://leetcode-cn.com/problems/n-queens-ii/) | [N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/) | 🔴️ 困难  | 位运算  | -   |  2  |
| [37](https://leetcode-cn.com/problems/sudoku-solver/) | [解数独](https://leetcode-cn.com/problems/sudoku-solver/) | 🔴️ 困难  | 递归、位运算、、A*  | -   |  2  |
| [212](https://leetcode-cn.com/problems/word-search-ii/) | [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/) | 🔴️ 困难  | 字典树  | -   |  2  |
| [70](https://leetcode-cn.com/problems/climbing-stairs/) | [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) | 🟢 简单  | 递归、剪枝、动态规划  | -   |  4  |
| [127](https://leetcode-cn.com/problems/word-ladder/) | [单词接龙](https://leetcode-cn.com/problems/word-ladder/) | 🟡 中等  | 双向BFS  | -   |  2  |
| [22](https://leetcode-cn.com/problems/generate-parentheses/) | [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) | 🟡 中等  | 递归、剪枝  | -   |  3  |
| [200](https://leetcode-cn.com/problems/number-of-islands/) | [岛屿生成](https://leetcode-cn.com/problems/number-of-islands/) | 🟡 中等  | DFS、并查集  | -   |  2  |
| [547](https://leetcode-cn.com/problems/friend-circles/) | [朋友圈](https://leetcode-cn.com/problems/friend-circles/) | 🟡 中等  | 并查集、DFS  | -   |  2  |
| [208](https://leetcode-cn.com/problems/implement-trie-prefix-tree/) | [实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/) | 🟡 中等  | 字典树  | -   |  2  |
| [190](https://leetcode-cn.com/problems/reverse-bits/) | [颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/) | 🟢 简单  | 位运算  | -   |  2  |
| [231](https://leetcode-cn.com/problems/power-of-two/) | [2的幂](https://leetcode-cn.com/problems/power-of-two/) | 🟢 简单  | 位运算  | -   |  2  |
| [191](https://leetcode-cn.com/problems/number-of-1-bits/) | [位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/) | 🟢 简单  | 位运算  | -   | 2  |
| [51](https://leetcode-cn.com/problems/n-queens/) | [N皇后](https://leetcode-cn.com/problems/n-queens/) | 🔴️ 困难  | 递归、DFS、BFS  | -   |  3  |
| [32](https://leetcode-cn.com/problems/longest-valid-parentheses/) | [最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) | 🔴️ 困难  | 动态规划、栈  | -   |  2  |
| [130](https://leetcode-cn.com/problems/surrounded-regions/) | [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/) | 🟡 中等  | 并查集  | -   |  1  |
| [36](https://leetcode-cn.com/problems/valid-sudoku/) | [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/) | 🟡 中等  | 位运算、字典树  | -   |  1  |
| [433](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | 🟡 中等  | 位运算、BFS  | -   |  1  |
| [1091](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/) | [二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/) | 🟡 中等  | BFS、A*  | -   |  1  |
| [338](https://leetcode-cn.com/problems/counting-bits/) | [比特位计数](https://leetcode-cn.com/problems/counting-bits/) | 🟡 中等  | 位运算、动态规划  | -   |  1  |
| [773](https://leetcode-cn.com/problems/sliding-puzzle/) | [滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/) | 🔴️ 困难  | 字典树、BFS、A* | -   |  1  |
