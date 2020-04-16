import edu.princeton.cs.algs4.In;

public class Main {
    public static void main(String[] args) {
        In in = new In("tinyEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());
    }
}
