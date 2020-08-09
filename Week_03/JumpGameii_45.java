// 1. ̰���㷨������̰�ģ� ��Ҫѭ������ O(n^2)���Ӷ�
// 2. ����̰��


// ����̰�� O(n)


class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //����������Զ��
            maxPosition = Math.max(maxPosition, nums[i] + i); 
            if( i == end){ //�����߽磬�͸��±߽磬���Ҳ�����һ
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}