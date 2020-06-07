public class kmpStringMatcher implements stringMatcher {
    /**
     * 获得匹配字符串中字符的匹配数值函数
     * 根据匹配字符串的前缀和后缀的公共字符个数而得到的数值
     * @param p 匹配字符串
     * @return 返回每个字符的匹配数值
     */
    private int[] getNext(char[] p) {
        int pLen = p.length;
        int[] next  = new int[pLen];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                k ++;
                j ++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    @Override
    public int indexOf(String source, String pattern) {
        int i = 0;
        int j = 0;
        int sLen = source.length();
        int pLen = pattern.length();
        char[] src = source.toCharArray();
        char[] pat = pattern.toCharArray();
        int[] next = getNext(pat);
        while (i < sLen && j < pLen) {
            /*
            如果匹配，直接后移
             */
            if (j == -1 || src[i] == pat[j]) {
                i ++;
                j ++;
            } else {
                /*
                如果不匹配，使用前面的匹配值来进行相应的位移
                 */
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        }
        return -1;
    }
}
