import java.util.List;

public class Solution2 {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            //�ҵ�d�п������ֵ�a��ƥ����ַ���
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i ++;
                }
            }
            //�жϸ�״̬��d�е��ַ����Ƿ����ֵ�a��
            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                //���ڶ��ƥ����ַ���ʱ�Ƚ��ַ����ĳ��Ⱥ��ֵ���
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }
}
