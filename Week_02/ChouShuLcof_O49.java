//1.������������������2��3��5��������С˳���������
//2. С����
//3. ��̬�滮


//2. С���� ʱ�临�ӶȽϴ�
class Solution {
    private int[] uglyNumber = {2,3,5};
    public int nthUglyNumber(int n) {
        //����С���ѣ�ÿ�γ��ѵĶ�����Сֵ
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        //��¼���ѵĸ��������ѵ�Ԫ����ȫ���մ�С��������
        int count = 0;
        while (! queue.isEmpty()){
            long cut = queue.poll();

            //������ѵĸ���>=n,��ǰcut���ǵ�n������
            if(++count >= n){
                return (int) cut;
            }
            for(int num : uglyNumber){
                //�ų��ظ�������
                if(! queue.contains(num * cut)){
                    queue.add(num * cut);
                }
            }
        }
        return -1;
    }
}

//��һ��