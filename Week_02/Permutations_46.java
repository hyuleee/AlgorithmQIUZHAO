//1. 递归
//2. 回溯


// 解法1 递归
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    boolean[] visted;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        visted = new boolean[nums.length];
        process(list,nums);
        return lists;
    }

    private void process( List<Integer> list, int[] nums) {
        //终止条件
        if(list.size() == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(!visted[i]){
                visted[i] = true;
                //加入
                list.add(nums[i]);
                process(list,nums);
                //回退
                list.remove(list.size()-1);
                visted[i] = false;

            }
        }
    }
}


//第一遍