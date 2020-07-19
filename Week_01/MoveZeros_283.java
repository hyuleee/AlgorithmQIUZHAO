class Solution {
    public void moveZeroes(int[] nums) {
            // 将非0项往前移
            int j = 0;  // j为0所在位置
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
    }
}

// 第一遍