## 学习笔记

### 动态规划 Dynamic programming
与递归、分治根本无区别
  共性：找重复子问题
  差异性：最优子结构、中途可淘汰次优解

**关键**


```
// DP
//  a.重复性（分治） problem(i) = subproblem(i);
//  b. 定义状态数组：f[i]
//  c. DP方程：f[i] = min(f[i+1, j], f[i+1, j+1]) + a[i, j]
//     Fib:opt[i] = opt[n-1] + opt[n-2];
//     二维路径：opt[i, j] = opt[i+1][j] + opt[i][j+1](且判断a[i, j]是否为空地)

```

#### 斐波那契数的优化

1. 自顶向下 直接递归分治 2^n

```

int fib (int n) {
  if (n <= 0) {
    return 0;
  } else if (n == 1) {
    return 1;
  } else {
    return fib (n - 1) + fib (n - 2);
  }
}

// 优化写法
int fib (int n) {
  return n <= 1 ? n : fib (n - 1) + fib (n - 2);
}

```

2. 中间缓存数据递归 n

```
int fib (int n, int[] memo) {
  if (n <= 0) {
    return 0;
  } else if (n == 1) {
    return 1;
  } else if (memo[n] == 0){    // 缓存未启动即未开始递归
    memo[n] = fib (n - 1) + fib (n - 2);
  }
  return memo[n];
}


```


3. 自底向上 动态规划循环 n

```
int fib (int n, int[] a) {
  a[0] = 0;
  a[1] = 1;
  for (int i = 2; i <= n; i++) {
    a[i] = a[i-1] + a[i-2];
  }
  return a[i];
}

```


#### 针对类似不同路径的二维题目
1. 找到重复子问题，从尾向前判断
2. 中间状态数组可以从二维优化至一维


```
\\ 二维状态数组
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1; //最后一行赋全1
        for (int i = 0; i < m; i++) dp[i][0] = 1; // 最后一列赋全1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    
\\ 一维状态数组 只需保存当前行，往上依次推
    public int uniquePaths (int m, int n) {
        int [] cur = new int[n];
        Arrays.fill(cur, 1); // 将最后一行数组全替换为1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

```

学习动态规划后，再考虑一道题的时候习惯性的使用动态规划，忘记了可能的DFS和BFS的使用，还是需要多练题，多总结，多看优秀的题解



### Week04刷题记录


| 题号                                                                                                                  | 名称                                                                            | 难度     | 分类         | 备注   | 次数    |
| ------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ------ | ---------- | ---- | ---- |
| [62](https://leetcode-cn.com/problems/unique-paths/) | [不同路径](https://leetcode-cn.com/problems/unique-paths/) | 🟡中等  | 动态规划、递归  | -   |  2  |
| [63](https://leetcode-cn.com/problems/unique-paths-ii/) | [不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/) | 🟡中等  | 动态规划、递归  | -   |  2  |
| [63](https://leetcode-cn.com/problems/unique-paths-ii/) | [不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/) | 🟡 中等  | 动态规划、递归  | -   |  1  |
| [1143](https://leetcode-cn.com/problems/longest-common-subsequence/) | [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) | 🟡 中等  | 贪心算法、回溯、动态规划  | -   |  1  |
| [70](https://leetcode-cn.com/problems/climbing-stairs/) | [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) | 🟢 简单  | 递归、回溯、动态规划  | -   |  3  |
| [120](https://leetcode-cn.com/problems/triangle/) | [三角形最小路径和](https://leetcode-cn.com/problems/triangle/) | 🟡 中等  | 贪心算法、回溯、动态规划  | -   |  1  |
| [53](https://leetcode-cn.com/problems/maximum-subarray/) | [最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) | 🟢 简单  | 贪心算法、动态规划  | -   |  2  |
| [152](https://leetcode-cn.com/problems/maximum-product-subarray/) | [乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/) | 🟡 中等  | 贪心算法、动态规划  | -   |  1  |
| [322](https://leetcode-cn.com/problems/coin-change/) | [零钱兑换](https://leetcode-cn.com/problems/coin-change/) | 🟡 中等  | 递归、DFS、动态规划  | -   |  2  |
| [198](https://leetcode-cn.com/problems/house-robber/) | [打家劫舍](https://leetcode-cn.com/problems/house-robber/) | 🟢 简单  | 递归、BFS、动态规划  | -   |  2  |
| [213](https://leetcode-cn.com/problems/house-robber-ii/) | [打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/) | 🟡 中等  | 递归动态规划  | -   |  1  |
| [121](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) | [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) | 🟢 简单  | 贪心、递归、动态规划  | -   |  1  |
| [123](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/) | [买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/) | 🔴️ 困难  | 贪心算法、二分查找、动态规划  | -   |  1  |
| [309](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | [最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | 🟡 中等  | 贪心算法、回溯、动态规划  | -   |  1  |
| [188](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/) | [买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/) | 🔴️ 困难  | 贪心算法、动态规划  | -   |  1  |
| [714](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | [买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | 🟡 中等  | 贪心算法、递归、动态规划  | -   |  1  |
| [72](https://leetcode-cn.com/problems/edit-distance/) | [编辑距离](https://leetcode-cn.com/problems/edit-distance/) | 🔴️ 困难  | 递归、DFS、动态规划  | -   |  1  |
| [64](https://leetcode-cn.com/problems/minimum-path-sum/) | 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) | 🟡 中等  | DFS、递归、动态规划  | -   |  1  |
| [91](https://leetcode-cn.com/problems/decode-ways/) | [解码方法](https://leetcode-cn.com/problems/decode-ways/) | 🟡 中等  | DFS、递归、动态规划  | -   |  0  |
| [221](https://leetcode-cn.com/problems/maximal-square/) | [最大正方形](https://leetcode-cn.com/problems/maximal-square/) | 🟡 中等  | BFS、递归、动态规划  | -   |  1  |
| [621](https://leetcode-cn.com/problems/task-scheduler/) | [任务调度器](https://leetcode-cn.com/problems/task-scheduler/) | 🟡 中等  | 贪心算法、堆  | -   |  0  |
| [647](https://leetcode-cn.com/problems/palindromic-substrings/) | [回文子串](https://leetcode-cn.com/problems/palindromic-substrings/) | 🟡 中等  | 分治、动态规划  | -   |  1  |
| [552](https://leetcode-cn.com/problems/student-attendance-record-ii/) | [学生出勤记录 II](https://leetcode-cn.com/problems/student-attendance-record-ii/) | 🔴️ 困难  | DFS、回溯、动态规划  | -   |  0  |
| [76](https://leetcode-cn.com/problems/minimum-window-substring/) | [最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) | 🔴️ 困难  | 贪心、双指针、动态规划  | -   |  1  |
| [312](https://leetcode-cn.com/problems/burst-balloons/) | [戳气球](https://leetcode-cn.com/problems/burst-balloons/) | 🔴️ 困难  | 递归、动态规划  | -   |  0  |
| [32](https://leetcode-cn.com/problems/longest-valid-parentheses/) | [最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) | 🔴️ 困难  | 贪心、双指针、动态规划  | -   |  0  |
| [363](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/) | [矩形区域不超过 K 的最大数值和](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/) | 🔴️ 困难  | 二分查找、动态规划  | -   |  0  |
| [403](https://leetcode-cn.com/problems/frog-jump/) | [青蛙过河](https://leetcode-cn.com/problems/frog-jump/) | 🔴️ 困难  | DFS、动态规划  | -   |  0  |
| [410](https://leetcode-cn.com/problems/split-array-largest-sum/) | [分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/) | 🟢 简单  | 贪心、二分、动态规划| -   |  0  |
