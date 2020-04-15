import java.util.ArrayList;
import java.util.List;

// LazyPrim ������� Prim ʵ�֣�Prim������ķ��
// MST��Minimum Spanning Tree����С������
public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightGraph<Weight> G;// ͼ������
    private MinHeap<Edge<Weight>> pq;// ��С��
    private boolean[] marked; // ������飬���㷨���й����б�ǽ�� i �Ƿ񱻷���
    private List<Edge<Weight>> mst; // ��С�����������������б�
    private Number mstWeight;//��С��������Ȩֵ

    // �ڹ��췽���������С�������ļ���
    public LazyPrimMST(WeightGraph<Weight> graph) {

        // ��ʼ��һЩ��Ա�����͸��������ݽṹ
        this.G = graph;
        pq = new MinHeap(graph.E());// lazy prim �㷨ÿ�ο��ǵıߵ���������ͼ�����ı���
        marked = new boolean[this.G.V()];
        mst = new ArrayList<>();

        // lazt prim
        visit(0);
        while (!pq.isEmpty()) { // ÿ�ζ��ó����ǵıߵ���Сֵ���������ǲ��Ǻ��бߣ������ lazy prim ��֮Ϊ lazy ��ԭ��
            // ʹ����С���ҳ��Ѿ����ʵı���Ȩֵ��С�ı�
            Edge<Weight> e = pq.extractMin();
            // ��������ߵ����˶��Ѿ����ʹ���, ���ӵ�������
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }
            // ���������߾�����С�������е�һ����
            mst.add(e);

            // ������Ϊ������һ����������ȱ���
            // ���������л�û�б����ʹ����Ǹ����㣬ִ�к�һ��ʼһ���� visit ����
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }

        // ��С���е�Ԫ�ض��������Ժ󣨸���������߼���Ҫ��������Щ���Ǻ��бߵıߣ�
        this.mstWeight = mst.get(0).weight();
        for (int i = 1; i < mst.size(); i++) {
            this.mstWeight = this.mstWeight.doubleValue() + mst.get(i).weight().doubleValue();
        }
    }

    // ����һ�����㣬ֻ��һ�����飬�����������ֱ�������Ļ�δ������С�ѵı߼�����С��
    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge<Weight> e : this.G.adj(v)) {
            // ��ע�⡿���������ֻҪ����һ���˵㻹û�б���ǹ�����ô�ͱ�ʾ�����߻�δ���뵽��С����
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    // ������С�����������б�
    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    // ������С��������Ȩֵ
    public Number result() {
        return mstWeight;
    }
}