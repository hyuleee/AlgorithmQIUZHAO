// 1. ������⣬����Ŀˮ�ܴﵽ�����λ�ã������������߶ȵĽ�Сֵ��ȥ��ǰ�߶ȵ�ֵ
// 2. ��̬�滮
// 3. ��̬�滮��˫ָ���Ż�
// 4. ջ ��Ч������ƥ�䣬��ǰ�߶ȵ���ջ�� ��ջ������ջ�ף���ջ������ˮ��


// �ⷨ4 ջ
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
        //���ջ���ղ��ҵ�ǰָ��ĸ߶ȴ���ջ���߶Ⱦ�һֱѭ��
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //ȡ��Ҫ��ջ��Ԫ��
                stack.pop(); //��ջ
                if (stack.empty()) { // ջ�վͳ�ȥ
                    break; 
                }
                int distance = current - stack.peek() - 1; //����ǽ֮ǰ�ľ��롣
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //��ǰָ���ǽ��ջ
            current++; //ָ�����
        }
        return sum;
    }

}

//��һ��