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
     * 初始化一个空的带权值图
     * @param V 节点数量
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
     * 从文件中读取带权图
     * @param in 读入文件
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
     * 初始化加权图
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
     *返回节点数
     * @return 返回节点数
     */
    public int V() {
        return V;
    }

    /**
     * 返回边数
     * @return 返回边
     */
    public int E() {
        return E;
    }

    /**
     * 判断边V的范围
     * @param v 边
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("V " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**
     * 向边集中添加边
     * @param e 待添加元素
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
     * 返回加权图的边
     * @param v 边
     * @return 返回边
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * 返回加权图每个结点
     * @return 返回节点
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
