//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 254 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 1. 暴力枚举 n^2
// 2. 找重复用map(hashmap 1, treemao logN)
// 3. hashtable


// class Solution {
//     public int firstUniqChar(String s) {
//         int[] count = new int[26];
//         char[] c = s.toCharArray();
//         for(int i = 0; i < c.length; i++) {
//             count[c[i] - 'a']++;
//         }

//         for (int i = 0; i < c.length; i++) {
//             if (count[c[i] - 'a'] == 1) return i;
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) return i;
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
