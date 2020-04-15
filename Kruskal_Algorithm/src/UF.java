public class UF {

    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components

    /**
     * 初始化0到n-1个元素的n个元素的集合
     * @param  n 元素个数
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
     *p所在集合的标识符
     * @param  p 元素p
     * @return p所在集合的标识符
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
     * 返回集合的大小
     *
     * @return 集合的大小
     */
    public int count() {
        return count;
    }

    /**
     * 如果两个元素在同一个集合中返回true
     *
     * @param  p 一个元素
     * @param  q 另一个元素
     * @return 如果p、q在同一个集合中，返回true
     */
    @Deprecated
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     *在p、q之间添加连接
     * @param  p 一个元素
     * @param  q 另一个元素
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // 将较小的根指向较大的根
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
     * 验证P是否有效
     * @param p
     */
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }
}
