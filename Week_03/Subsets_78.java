// 1. 每个位置可以选择乘以1或者乘以0，类似于括号生成
// 2. 迭代


// 1. 递归

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList <>();
        if (nums == null) {return ans;}
        dfs(ans, nums, new ArrayList<Integer> (), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        // teminator
        if (index == nums.length) {
            ans.add(new ArrayList<Integer> (list));
            return;
        }

        dfs(ans, nums, list, index + 1); // not pick the number  at the index

        list.add(nums[index]);  // pick the number at this index
        dfs(ans, nums, list, index + 1);

        //restore state
        list.remove(list.size() - 1);
    }
}

// 第一遍