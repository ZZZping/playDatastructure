import java.util.List;

public class LazyPrimMSTTest {

    public static void main(String[] args) {
        String filename = "tinyEWG.txt";
        int v = 8;
        // ��Ȩͼ
        SpareWeightedGraph<Double> g = new SpareWeightedGraph<>(v, false);
        ReadWeightedGraphUtil readWeightedGraphUtil = new ReadWeightedGraphUtil(g, filename);
        g.show();
        System.out.println("��С�������� Prim �㷨����ʱʵ�֣�");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(g);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        mst.forEach(System.out::println);
    }
}
