public class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        //freq���������ĸ������freq��һ����СΪ26�����飬�������δ��a-z26����ĸ
        for (int i = 0; i < s.length(); i ++) {
            freq[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            //�ж��Ƿ�����ͬ����ĸ
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
