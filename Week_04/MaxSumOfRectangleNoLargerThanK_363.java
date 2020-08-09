//1. ������̬�滮
//2. ���ֶ�̬�滮

// // �ⷨ1
// class Solution {
//     public int maxSumSubmatrix(int[][] matrix, int k) {
//         int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
//         for (int i1 = 1; i1 <= rows; i1++) {
//             for (int j1 = 1; j1 <= cols; j1++) {
//                 int[][] dp = new int[rows + 1][cols + 1]; // renew  // from (i1,j1) to (i2,j2)
//                 dp[i1][j1] = matrix[i1 - 1][j1 - 1];
//                 for (int i2 = i1; i2 <= rows; i2++) {
//                     for (int j2 = j1; j2 <= cols; j2++) {
//                         dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
//                         if (dp[i2][j2] <= k && dp[i2][j2] > max) max = dp[i2][j2];
//                     }
//                 }
//             }
//         }
//         return max;
//     }

// }

// �ⷨ2

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // ö����߽�
            int[] rowSum = new int[rows]; // ��߽�ı������������¿�ʼ
            for (int r = l; r < cols; r++) { // ö���ұ߽�
                for (int i = 0; i < rows; i++) { // ��ÿһ���ۼƵ� dp
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) return k; // ������ǰ
            }
        }
        return max;
    }
    // ������ arr �У��󲻳��� k �����ֵ
    private int dpmax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k; // ������ǰ
            }
        }
        return max;
    }
}
