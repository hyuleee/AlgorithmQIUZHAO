// 1. hash���sort
// 2. hash��С����


// �ⷨ2 heap

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // key: Ԫ�أ�value: ���ֵĴ���
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int times = map.getOrDefault(num, 0);
            map.put(num, times + 1);
        }
        // ����
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

//��һ��