// ˫ָ�� i, j һ��ָ���һλ��һ��ָ���һλ���Ա�����ָ���ֵ�Ƿ����
//  �����ڶ���ָ��������һλ��ֱ�����ȣ�nums[i+1] = nums[j] i+1


class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                //��Ϊǰ�涼�ǲ����ظ�����Բ����ж�ֵ��ȣ�ֻ��Ҫ���߼������1
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

//��һ��