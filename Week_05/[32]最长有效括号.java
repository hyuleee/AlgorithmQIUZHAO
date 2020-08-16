//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 909 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 1. 栈方法
// 2. DP

// // 解法2

// class Solution {
//     public int longestValidParentheses(String s) {
//         if (s == null || s.length() == 0) return 0;
//         int[] dp = new int[s.length()];
//         int res = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (i > 0 && s.charAt(i) == ')') {
//                 if (s.charAt(i - 1) == '(') {
//                     dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
//                 } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                     dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
//                 }
//             }
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }


// 解法1
public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
