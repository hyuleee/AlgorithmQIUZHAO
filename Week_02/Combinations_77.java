//1.���� ����
//2.�ݹ�
//3.��̬�滮


// �ⷨ2 �ݹ�
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        // n - 1 ���ѡ k - 1 ��
        List<List<Integer>> result = combine(n - 1, k - 1);
        //ÿ��������� n
        result.forEach(e -> e.add(n));
        //�� n - 1 ��ѡ k ���Ľ��Ҳ����
        result.addAll(combine(n - 1, k));
        return result;
    }

}

//��һ��