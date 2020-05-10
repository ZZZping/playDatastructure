import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Set<String> duplicates = getDuplicates(strs);
        for (int i = 0; i < strs.length; i ++) {
            if (!duplicates.contains(strs[i])) {
                if (i == 0) {
                    return strs[0].length();
                }
                for (int j = 0; j < i; j ++) {
                    if (isSequence(strs[j], strs[i])) {
                        break;
                    }
                    if (j == i - 1) {
                        return strs[i].length();
                    }
                }
            }
        }
        return -1;
    }

    /**
     * »ñµÃÖØ¸´Ïî
     * @param str Ä¿±ê×Ö·û´®
     * @return ·µ»ØÖØ¸´×Ö·û´®
     */
    private Set<String> getDuplicates(String[] str) {
        Set<String> set = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String s : str) {
            if (set.contains(s)) {
                duplicates.add(s);
            }
            set.add(s);
        }
        return duplicates;
    }

    /**
     * ÅÐ¶ÏÊÇ·ñÎª×Ó´®
     * @param a ×Ö·û´®A
     * @param b ×Ö·û´®B
     * @return ·µ»ØÅÐ¶Ï
     */
    private boolean isSequence(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j ++;
            }
            i ++;
        }
        return j == b.length();
    }
}

