public class kmpStringMatcher implements stringMatcher {
    /**
     * ���ƥ���ַ������ַ���ƥ����ֵ����
     * ����ƥ���ַ�����ǰ׺�ͺ�׺�Ĺ����ַ��������õ�����ֵ
     * @param p ƥ���ַ���
     * @return ����ÿ���ַ���ƥ����ֵ
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
            ���ƥ�䣬ֱ�Ӻ���
             */
            if (j == -1 || src[i] == pat[j]) {
                i ++;
                j ++;
            } else {
                /*
                �����ƥ�䣬ʹ��ǰ���ƥ��ֵ��������Ӧ��λ��
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
