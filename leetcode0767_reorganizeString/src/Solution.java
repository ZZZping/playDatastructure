/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 */

/**
 * 1.使用hash表存储字符串中每一个字母
 * 2.找到字符串中出现次数最多的字母
 * 3.将出现次数最多的字母放到偶数索引中
 * 4.将其他的字母放到数组中
 * input == aaabbbcdd
 * a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
 * a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
 * a b a c a _ b _ b // fill in "c" at position 3
 * a b a c a d b d b // fill in "d" at position 5, 7
 */
public class Solution {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i ++) {
            hash[S.charAt(i) - 'a'] ++;
        }
        int max = 0;
        int letter = 0;

        //找到出现次数最多的字母
        for (int i = 0; i < hash.length; i ++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        //无法重新排列时返回空字符串
        if (max > (S.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[S.length()];
        int idx = 0;
        //将出现字数最多的字符放到偶数索引中
        while (hash[letter] > 0) {
            res[idx] = (char)(letter + 'a');
            idx += 2;
            hash[letter] --;
        }

        for (int i = 0; i < hash.length; i ++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char)(i + 'a');
                idx += 2;
                hash[i] --;
            }
        }

        return String.valueOf(res);

    }
}
