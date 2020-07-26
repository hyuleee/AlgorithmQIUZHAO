//1.暴力法，所有能整除2、3、5的数按大小顺序放入数组
//2. 小根堆
//3. 动态规划


//2. 小根堆 时间复杂度较大
class Solution {
    private int[] uglyNumber = {2,3,5};
    public int nthUglyNumber(int n) {
        //创建小根堆，每次出堆的都是最小值
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        //记录出堆的个数，出堆的元素完全按照从小到大排序
        int count = 0;
        while (! queue.isEmpty()){
            long cut = queue.poll();

            //如果出堆的个数>=n,当前cut就是第n个丑数
            if(++count >= n){
                return (int) cut;
            }
            for(int num : uglyNumber){
                //排除重复的数字
                if(! queue.contains(num * cut)){
                    queue.add(num * cut);
                }
            }
        }
        return -1;
    }
}

//第一遍