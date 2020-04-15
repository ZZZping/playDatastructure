public class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weight;

    /**
     * J���ߵĳ�ʼ�ڵ㣬ĩβ�ڵ㣬Ȩ�س�ʼ��
     * @param v ��ʼ�ڵ�
     * @param w ĩβ�ڵ�
     * @param weight Ȩ��
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
     * ��ʼ�ڵ�
     * @return ���س�ʼ�ڵ�
     */
    public int either() {
        return v;
    }

    /**
     * ĩβ�ڵ�
     * @param vertex ���жϽڵ�
     * @return ����ĩβ�ڵ�
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
     * �Ƚ������ߵ�Ȩ��
     * @param that ��һ����
     * @return ���رȽϽ����this weight < that weight --> -1
     *                     this weight == that weight --> 0
     *                      this weight < that weight --> 1
     */
    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    /**
     * ����ÿ���ߵı�ʾ
     * @return �ߵı�ʾ
     */
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
