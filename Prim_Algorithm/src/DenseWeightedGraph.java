import java.util.ArrayList;
import java.util.List;

// ��Ȩͼ�ĳ���ͼʵ��
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightGraph {

    private int n;// �ڵ���
    private int m;// ����
    private boolean directed; // �Ƿ�������ͼ
    private Edge<Weight>[][] g;// ͼ�ľ������ݣ��б߾����˽ڵ���Ϣ�����ܱ�ʾͼ

    public DenseWeightedGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n; // ������
        this.m = 0;
        this.directed = directed; // �Ƿ�����
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    // ���ؽڵ�ĸ���
    @Override
    public int V() {
        return n;
    }

    // ���رߵ�����
    @Override
    public int E() {
        return m;
    }

    // ���һ����
    @Override
    public void addEdge(Edge edge) {
        assert edge.v() >= 0 && edge.v() < n;
        assert edge.w() >= 0 && edge.w() < n;
        if (hasEdge(edge.v(), edge.w())) {
            // ����Ѿ����������߾�ʲô������
            return;
        }
        g[edge.v()][edge.w()] = new Edge(edge);
        if (!directed) { // edge.v()!=edge.w() &&
            // ���������ͼ�����Ż�Ҫ���һ��
            g[edge.w()][edge.v()] = new Edge(edge);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.print(String.format("%.2f", g[i][j].weight()) + "\t");
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    // ����ͼ��һ������������ڱߣ����� Java ʹ�����û��ƣ�����һ�� Vector ����������⿪��,
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        List<Edge<Weight>> adjV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
