import java.util.ArrayList;
import java.util.List;

// ��Ȩͼ��ϡ��ͼʵ��
public class SpareWeightedGraph<Weight extends Number & Comparable> implements WeightGraph {

    private int n;// �ڵ���
    private int m;// ����
    private boolean directed; // �Ƿ�Ϊ����ͼ
    private List<Edge<Weight>>[] g;

    public SpareWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // ��ʼ����д���е�֣�Ҫ���⣬�޷Ǿ�����ǿ������ת��
        g = (ArrayList<Edge<Weight>>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Edge<Weight>>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge edge) {
        assert edge.v() >= 0 && edge.v() < n;
        assert edge.w() >= 0 && edge.w() < n;
        // ��ʹ���ڽӱ��ʾ��Ȩͼ��ʱ���������Ƿ����ظ��ߣ�Ҫ������������
        // Ϊ���������������ظ��ߣ��� hasEdge �Ͳ�����
        g[edge.v()].add(new Edge(edge));
        if (!directed) {// edge.v()!=edge.w()
            // ע�⣺�������Ƕ��������������еıߵ� w ������������������ w ֵ
            // �����������һ�д���ΪʲôҪ��д edge.w() ��д edge.v() ��ԭ��
            // ������Ǻ���⣬��ͼ��ʵ���㷨��ʱ�򣬾ͻ������
            g[edge.w()].add(new Edge(edge.w(), edge.v(), edge.weight()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertext " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                if (g[i].get(j) != null) {
                    Edge e = g[i].get(j);
                    System.out.print("(to: " + e.other(i) + ",wt:" + String.format("%.2f", e.weight()) + ")\t");
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
