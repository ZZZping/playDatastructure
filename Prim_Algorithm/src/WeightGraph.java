public interface WeightGraph<Weight extends Number & Comparable> {
    //顶点数
    int V();
    //边数
    int E();
    //乡土中添加权值为weight的边
    void addEdge(Edge<Weight> edge);
    //判断图中是否有v到w的边
    boolean hasEdge(int v, int w);
    //显示时图信息
    void show();
    //返回图中一个顶点的所有邻边
    Iterable<Edge<Weight>> adj(int v);

}
