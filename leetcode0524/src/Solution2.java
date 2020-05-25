import java.util.List;

public class Solution2 {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            //找到d中可以在字典a中匹配的字符串
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i ++;
                }
            }
            //判断该状态下d中的字符串是否在字典a中
            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                //存在多个匹配的字符串时比较字符串的长度和字典序
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }
}
