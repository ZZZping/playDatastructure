import MST.Kurskal.Bag;
import MST.Kurskal.Edge;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;

    /**
     * ��ʼ��һ���յĴ�Ȩֵͼ
     * @param V �ڵ�����
     */
    public EdgeWeightedGraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of V must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0 ; v < V ; v ++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * ���ļ��ж�ȡ��Ȩͼ
     * @param in �����ļ�
     */
    public EdgeWeightedGraph(In in) {
        if (in == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        try {
            V = in.readInt();
            adj = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v ++) {
                adj[v] = new Bag<Edge>();
            }
            int E = in.readInt();
            if (E < 0) {
                throw new IllegalArgumentException("Number of E must be nonnegative");
            }
            for (int i = 0; i < E; i ++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                double weight = in.readDouble();
                Edge e= new Edge(v, w, weight);
                addEdge(e);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
        }
    }

    /**
     * ��ʼ����Ȩͼ
     * @param G
     */
    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v ++) {
            Stack<Edge> reverse = new Stack<>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }

    /**
     *���ؽڵ���
     * @return ���ؽڵ���
     */
    public int V() {
        return V;
    }

    /**
     * ���ر���
     * @return ���ر�
     */
    public int E() {
        return E;
    }

    /**
     * �жϱ�V�ķ�Χ
     * @param v ��
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("V " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**
     * ��߼�����ӱ�
     * @param e �����Ԫ��
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * ���ؼ�Ȩͼ�ı�
     * @param v ��
     * @return ���ر�
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * ���ؼ�Ȩͼÿ�����
     * @return ���ؽڵ�
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<>();
        for (int v = 0; v < V; v ++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops ++;
                }
            }
        }
        return list;
    }


}
