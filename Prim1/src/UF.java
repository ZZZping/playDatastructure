public class UF {

    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components

    /**
     * ��ʼ��0��n-1��Ԫ�ص�n��Ԫ�صļ���
     * @param  n Ԫ�ظ���
     */
    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     *p���ڼ��ϵı�ʶ��
     * @param  p Ԫ��p
     * @return p���ڼ��ϵı�ʶ��
     */
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    /**
     * ���ؼ��ϵĴ�С
     *
     * @return ���ϵĴ�С
     */
    public int count() {
        return count;
    }

    /**
     * �������Ԫ����ͬһ�������з���true
     *
     * @param  p һ��Ԫ��
     * @param  q ��һ��Ԫ��
     * @return ���p��q��ͬһ�������У�����true
     */
    @Deprecated
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     *��p��q֮���������
     * @param  p һ��Ԫ��
     * @param  q ��һ��Ԫ��
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // ����С�ĸ�ָ��ϴ�ĸ�
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        }
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count --;
    }

    /**
     * ��֤P�Ƿ���Ч
     * @param p
     */
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }
}
