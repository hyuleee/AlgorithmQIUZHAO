//��ĸ��λ�ʣ�ÿ����ĸ���ִ�����ͬ����˳��ͬ

//1.������sort, sort_str��ȣ�O(nlogn)
//2.hash, map ͳ��ÿ���ַ���Ƶ��


class Solution {
   public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;



    }
}

//��һ��