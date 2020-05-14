public class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        //freq用来存放字母个数，freq是一个大小为26的数组，用来依次存放a-z26个字母
        for (int i = 0; i < s.length(); i ++) {
            freq[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            //判断是否有相同的字母
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
