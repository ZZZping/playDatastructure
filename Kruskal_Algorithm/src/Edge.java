public class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weight;

    /**
     * J将边的初始节点，末尾节点，权重初始化
     * @param v 初始节点
     * @param w 末尾节点
     * @param weight 权重
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    /**
     * 初始节点
     * @return 返回初始节点
     */
    public int either() {
        return v;
    }

    /**
     * 末尾节点
     * @param vertex 待判断节点
     * @return 返回末尾节点
     */
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return w;
        } else {
            throw new IllegalArgumentException("Illegal endpoint");
        }
    }

    /**
     * 比较两条边的权重
     * @param that 另一条边
     * @return 返回比较结果，this weight < that weight --> -1
     *                     this weight == that weight --> 0
     *                      this weight < that weight --> 1
     */
    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    /**
     * 返回每条边的表示
     * @return 边的表示
     */
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
