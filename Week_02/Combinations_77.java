//1.回溯 迭代
//2.递归
//3.动态规划


// 解法2 递归
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        // n - 1 里边选 k - 1 个
        List<List<Integer>> result = combine(n - 1, k - 1);
        //每个结果加上 n
        result.forEach(e -> e.add(n));
        //把 n - 1 个选 k 个的结果也加入
        result.addAll(combine(n - 1, k));
        return result;
    }

}

//第一遍