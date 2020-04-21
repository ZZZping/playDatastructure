public class Main {

    public static void main(String[] args) {
        double startTime = System.nanoTime();
<<<<<<< HEAD
        In in = new In("large.txt");
=======
        In in = new In("edge.txt");
>>>>>>> 75c24794b58fb8df0e4ebd6feffcda94caa65dd9
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST kruskalMST = new KruskalMST(G);
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("Kruskal time is:" + time + " s");
//        for (Edge e : kruskalMST.edges()) {
//            System.out.println(e);
//        }
//        System.out.printf("%.5f\n",kruskalMST.weight());

        startTime = System.nanoTime();
        PrimMST primMST = new PrimMST(G);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("Prim time is:" + time + " s");
//        for (Edge e : kruskalMST.edges()) {
//            System.out.println(e);
//        }
//        System.out.printf("%.5f\n",kruskalMST.weight());
    }
}
