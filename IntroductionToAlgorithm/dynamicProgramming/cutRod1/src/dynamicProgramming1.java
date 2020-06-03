public class dynamicProgramming1 {
    /**
     * 动态规划算法1:根据价值数组p和数量n求得最大价值组合
     * @param p 保存价值的数组
     * @param n 数量
     * @return 返回最大价值
     */
    public int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            q = Math.max(q, p[i] + cutRod(p, n - i));
        }
        return q;
    }

    public int momoizedCutRod(int[] p, int n) {
        int[] r = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            r[i] = -100;
        }
        return momoizedCutRod(p, n, r);
    }

    private int momoizedCutRod(int[] p, int n, int[] r) {
        if (r[n] >= 0) {
            return r[n];
        }
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = -100;
            for (int i = 1; i <= n; i ++) {
                q = Math.max(q, p[i] + momoizedCutRod(p, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }

    public int bottomUpCutRod(int[] p, int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j ++) {
            int q = -100;
            for (int i = 1; i <= j; i ++) {
                q = Math.max(q, p[i] + r[j = i]);
            }
            r[j] = q;
        }
        return r[n - 1];
    }

}
