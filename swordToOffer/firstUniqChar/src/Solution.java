public class Solution {
    public char firstUniqChar(String s) {
        char ch = ' ';
        int[] freq = new int[26];
        if (s == " ") {
            return ' ';
        }
        for (int i = 0; i < s.length(); i ++) {
            freq[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                ch = s.charAt(i);
                break;
            }
        }
        return ch;
    }
}
