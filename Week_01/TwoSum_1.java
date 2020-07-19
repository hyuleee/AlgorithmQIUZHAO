// 1. 暴力法
// 2. 两个哈希表
// 3. 一个哈希表


// 解法1

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] a = new int[2];
//         int numsSize = nums.length;
//         for (int i = 0; i < numsSize - 1; i++) {
//             for (int j = i+1; j < numsSize; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     a[0] = i;
//                     a[1] = j;
//                     return a;
//                 }
//             }
//         }
//        return new int[0];        
//     }
// }

//第一遍


//解法2 一个哈希
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}