// 双指针 i, j 一个指向第一位，一个指向后一位，对比两个指针的值是否相等
//  相等则第二个指针往后移一位，直到不等，nums[i+1] = nums[j] i+1


class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                //因为前面都是不含重复项，所以不用判断值相等，只需要两者间隔大于1
                if(j - i > 1){
                    nums[i + 1] = nums[j];
                }
                i++;
            }
            j++;
        }
        return i + 1;
    }

}

//第一遍