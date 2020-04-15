public interface WeightGraph<Weight extends Number & Comparable> {
    //������
    int V();
    //����
    int E();
    //���������ȨֵΪweight�ı�
    void addEdge(Edge<Weight> edge);
    //�ж�ͼ���Ƿ���v��w�ı�
    boolean hasEdge(int v, int w);
    //��ʾʱͼ��Ϣ
    void show();
    //����ͼ��һ������������ڱ�
    Iterable<Edge<Weight>> adj(int v);

}
