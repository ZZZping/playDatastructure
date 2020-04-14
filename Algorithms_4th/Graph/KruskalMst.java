import edu.princeton.cs.algs4.*;

public class KruskalMst {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;
    private Queue<Edge> mst = new Queue<>();

    /**
     * �õ�һ����С������
     * @param G ͼG
     */
    public KruskalMst(EdgeWeightedGraph G){

        //ͨ����������Heap
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : edges()) {
            pq.insert(e);
        }

        //ʹ��greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w);
                mst.enqueue(e);
                weight += e.weight();
            }
        }
        assert check(G);
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        return weight;
    }

    private boolean check(EdgeWeightedGraph G){
        double total = 0.0;
        //������е�Ȩ��
        for (Edge e :edges()) {
            total += e.weight();
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight() : %f vs. %f\n", total, weight() );
            return false;
        }

        //�ж��Ƿ񲻰�����·
        UF uf = new UF(G.V());
        for (Edge e : edges()) {
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) == uf.find(w)) {
                System.err.printf("Not a forest!");
                return false;
            }
            uf.union(v, w);
        }

        //�ж��Ƿ���������
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                System.err.printf("Not a spanning forest");
                return false;
            }
        }

        //�ж��Ƿ�����С������
        for (Edge e : edges()) {
            //edges�г���e�����б�
            uf = new UF(G.V());
            for (Edge f : edges()) {
                int x = f.either();
                int y = f.other(x);
                if (uf.find(x) != uf.find(y)) {
                    uf.union(x, y);
                }
            }

            //�ж�e�Ƿ�Ϊ��С��
            for (Edge f : edges()) {
                int x = f.either();
                int y = f.other(x);
                if (uf.find(x) != uf.find(y)) {
                    if (f.weight() < e.weight()) {
                        System.err.printf("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMst mst = new KruskalMst(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());

    }

}
