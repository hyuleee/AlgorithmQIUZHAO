// 1. 贪心
// 2. 动态规划

// 贪心解法 时间O(n) 空间O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >prices[i - 1]) {
                max += prices[i] - prices[i -1];
            }
        }
        return max;
    }
}