class Solution {
    public void moveZeroes(int[] nums) {
            // ����0����ǰ��
            int j = 0;  // jΪ0����λ��
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

// ��һ��