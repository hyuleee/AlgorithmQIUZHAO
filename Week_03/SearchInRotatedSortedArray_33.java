// ��[0, mid] ����������: nums[0] <= nums[mid], ��target > nums[mid] || target < nums[0] ,������Լ
// ��[0, mid] ���д�����תλ: nums[0] > nums[mid],��target < nums[0] && target > nums[mid],������Լ
// ���������ǰ��Լ



class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // ��[0,mid]����ʱ,����Լ����
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
                // ��[0,mid]������תʱ������Լ����
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}
