// 1. hash表后sort
// 2. hash后小顶堆


// 解法2 heap

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // key: 元素，value: 出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int times = map.getOrDefault(num, 0);
            map.put(num, times + 1);
        }
        // 最大堆
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> (map.get(o2) - map.get(o1)));
        for (int key : map.keySet()) {
            pq.add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        while (index < k) {
            ans[index++] = pq.poll();
        }
        return ans;
    }
}

//第一遍