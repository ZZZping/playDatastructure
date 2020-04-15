import java.util.ArrayList;
import java.util.List;

// Prim �㷨�ļ�ʱʵ��
public class PrimMST<Weight extends Number & Comparable> {

    private WeightGraph<Weight> G;// ͼ������
    private IndexMinHeap<Weight> ipq;// ��С������
    private boolean[] marked;

    private Edge<Weight>[] edgeTo;// ���ʵĵ�����Ӧ�ı�
    private List<Edge<Weight>> mst; // ��С�����������������б�
    private Number mstWeight;//��С��������Ȩֵ

    public PrimMST(WeightGraph graph) {
        G = graph;
        ipq = new IndexMinHeap<>(graph.V());

        // ��ʼ�����������ݽṹ��һЩ��Ա����
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];

        for (int i = 0; i < G.V(); i++) {
            marked[i] = false;
            edgeTo[i] = null;
        }

        mst = new ArrayList<>();

        // Prim
        visit(0);
        while (!ipq.isEmpty()){
            int v = ipq.extractMinIndex();
            assert edgeTo[v]!=null;
            mst.add(edgeTo[v]);
            visit(v);
        }
        // ��С���е�Ԫ�ض��������Ժ󣨸���������߼���Ҫ��������Щ���Ǻ��бߵıߣ�
        this.mstWeight = mst.get(0).weight();
        for (int i = 1; i < mst.size(); i++) {
            this.mstWeight = this.mstWeight.doubleValue() + mst.get(i).weight().doubleValue();
        }
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v]=true;

        for(Edge<Weight> e: this.G.adj(v)){
            int w = e.other(v);
            // ����������һ���˵㻹û�з��ʹ�����ô�����߾Ϳ��Լ���������
            if(!marked[w]){
                if(edgeTo[w]==null){
                    edgeTo[w]= e;
                    ipq.insert(w,e.weight());
                }else if(e.weight().compareTo(edgeTo[w].weight())<0){
                    edgeTo[w]= e;
                    ipq.change(w,e.weight());
                }
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
