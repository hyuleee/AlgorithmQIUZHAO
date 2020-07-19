// 1. 暴力求解，按题目水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值
// 2. 动态规划
// 3. 动态规划下双指针优化
// 4. 栈 等效于括号匹配，当前高度低于栈底 入栈，高于栈底，出栈并计算水量


// 解法4 栈
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break; 
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

}

//第一遍