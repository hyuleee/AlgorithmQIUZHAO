## 学习笔记

### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

**思路**：思路和搜索旋转排序数组题目相似，无序部分即旋转点前后

**代码**：

```
// 当[0, mid] 序列升序: nums[0] <= nums[mid], 向后规约
// 当[0, mid] 序列存在旋转位: nums[0] > nums[mid],向前规约
 
public class Solution {

   public int search(int[] nums) {
      int le = 0 
      int ri = nums.length - 1;
      while (le <= ri) {
          int mid = le + (ri - le + 1) / 2;
          if (nums[mid] > nums[0]) {
              le = mid + 1;
          } else {
              ri = mid - 1;
          }
          if (nums[mid] <= nums[mid - 1] && nums[mid] <= nums[0] ) {
              return nums[mid];
          }
      }
      return 0;
   }
```


### 分治代码模板

```Java
public Object divideConquer(problem, param1, param2, ...){
    // recursion terminator
    if(problem == null){
        printResult
        return;    
    }
    // prepare data
    data = prepareDate(problem);
    subProblems = splitProblem(problem, data);
    // drill down
    subResult1 = divideConquer(subProblems[0], p1, ...);
    subResult2 = divideConquer(subProblems[1], p1, ...);
    // ...
    // result
    result = processResult(subResult1, subResult2, ...);
    // reverse 
}
```
### 回溯模板：

``` java
public void backtrack(int[] nums , int index , Stack<Integer> temp){
    for(int i = index; i < nums.length; i++){
        temp.push(nums[i]);
        backtrack(nums,i + 1 , temp); //drill down
        temp.pop(); 
    }
}
```
### BFS模板：

```Java
public List<List<Integer>> levelOrder (Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return res;
    }
```

### DFS模板：

```Java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) return list;
    travel(0, root, list);
    return list;
}
private void travel(int level, TreeNode root, List<List<Integer>> list) {
    if (level == list.size()) {
        list.add(new ArrayList<>());
        return ;
    }
    list.get(level).add(root.val);
    if (root.left != null) {
        travel(level + 1, root.left, list);
    }
    if (root.right != null) {
        travel(level + 1, root.right, list);
    }
}
```


### 二分查找代码模板:

```Java
public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
```




### Week03刷题记录


| 题号                                                                                                                  | 名称                                                                            | 难度     | 分类         | 备注   | 次数    |
| ------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ------ | ---------- | ---- | ---- |
| [45](https://leetcode-cn.com/problems/jump-game-ii/) | [跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/) | 🔴️ 困难  | 贪心算法  | -   |  1  |
| [33](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | 🟡 中等  | 二分查找  | -   |  1  |
| [78](https://leetcode-cn.com/problems/subsets/) | [子集](https://leetcode-cn.com/problems/subsets/) | 🟡 中等  | 回溯、DFS、二进制位  | -   |  1  |
| [455](https://leetcode-cn.com/problems/assign-cookies/) | [分发饼干](https://leetcode-cn.com/problems/assign-cookies/) | 🟢 简单  | 贪心算法  | -   |  1  |
| [122](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/) | [买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/) | 🟢 简单  | 贪心算法、动态规划  | -   |  1  |
| [50](https://leetcode-cn.com/problems/powx-n/) | [Pow(x, n)](https://leetcode-cn.com/problems/powx-n/) | 🟡 中等  | 分治、快速幂  | -   |  1  |
| [17](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) | [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) | 🟡 中等  | 回溯、DFS、动态规划  | -   |  1  |
| [200](https://leetcode-cn.com/problems/number-of-islands/) | [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 🟡 中等  | DFS、BFS  | -   |  1  |
| [51](https://leetcode-cn.com/problems/n-queens/discuss/19828/Comparably-concise-Java-code/) | [N皇后](https://leetcode-cn.com/problems/n-queens/discuss/19828/Comparably-concise-Java-code/) | 🔴️ 困难  | 回溯、DFS  | -   |  1  |
| [102](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) | [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) | 🟡 中等  | BFS、DFS  | -   |  1  |
| [22](https://leetcode-cn.com/problems/generate-parentheses/) | [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) | 🟡 中等  | 回溯、DFS、动态规划  | -   |  1  |
| [69](https://leetcode-cn.com/problems/sqrtx/) | [x 的平方根](https://leetcode-cn.com/problems/sqrtx/) | 🟢 简单  | 二分查找、牛顿迭代法  | -   |  1  |
| [860](https://leetcode-cn.com/problems/lemonade-change/description/) | [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/) | 🟢 简单  | 贪心算法、动态规划  | -   |  1  |
| [874](https://leetcode-cn.com/problems/walking-robot-simulation/description/) | [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/) | 🟢 简单  | 贪心算法、哈希表  | -   |  1  |
| [55](https://leetcode-cn.com/problems/jump-game/) | [跳跃游戏](https://leetcode-cn.com/problems/jump-game/) | 🟡 中等  | 贪心算法  | -   |  1  |
| [322](https://leetcode-cn.com/problems/coin-change/) | [零钱兑换](https://leetcode-cn.com/problems/coin-change/) | 🟡 中等  | 贪心算法、DFS、动态规划  | -   |  1  |
| [47](https://leetcode-cn.com/problems/permutations-ii/) | [有效的完全平方数](https://leetcode-cn.com/problems/permutations-ii/) | 🟢 简单  | 二分查找  | -   |  1  |
| [74](https://leetcode-cn.com/problems/search-a-2d-matrix/) | [搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/) | 🟡 中等  | 二分查找  | -   |  0  |
| [153](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | 🟡 中等  | 二分查找  | -   |  0  |
| [118](https://leetcode-cn.com/problems/pascals-triangle/) | [杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/) | 🟢 简单  | 动态规划  | -   |  0  |
| [119](https://leetcode-cn.com/problems/pascals-triangle-ii/) | [杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/) | 🟢 简单  | 哈希表、动态规划  | -   |  0  |
| [433](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | 🟡 中等  | BFS、回溯  | -   |  0  |
| [515](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/) | [在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/) | 🟡 中等  | DFS、BFS  | -   |  0  |
| [126](https://leetcode-cn.com/problems/word-ladder-ii/) | [单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/) | 🔴️ 困难  | DFS、BFS  | -   |  0  |
| [127](https://leetcode-cn.com/problems/word-ladder/) | [单词接龙](https://leetcode-cn.com/problems/word-ladder/) | 🟡 中等  | DFS、BFS  | -   |  0  |
| [529](https://leetcode-cn.com/problems/minesweeper/) | [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/) | 🟡 中等  | BFS、DFS  | -   |  0  |
| [169](https://leetcode-cn.com/problems/majority-element/description/) | [多数元素](https://leetcode-cn.com/problems/majority-element/description/) | 🟢 简单  | 哈希表、分治  | -   |  0  |
