// 当[0, mid] 序列是升序: nums[0] <= nums[mid], 当target > nums[mid] || target < nums[0] ,则向后规约
// 当[0, mid] 序列存在旋转位: nums[0] > nums[mid],当target < nums[0] && target > nums[mid],则向后规约
// 其他情况向前规约



class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 当[0,mid]有序时,向后规约条件
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
                // 当[0,mid]发生旋转时，向后规约条件
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}
