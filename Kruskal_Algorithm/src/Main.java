public class Main {
    public static void main(String[] args)  {
        double startTime = System.nanoTime();
        In in = new In("test2.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("Kruskal time is:" + time + " s");
//        for (Edge e : mst.edges()) {
//            System.out.println(e);
//        }
//        System.out.printf("%.5f\n", mst.weight());
    }
}
