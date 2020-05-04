public class UnionFind1 implements UF {
    private int[] id;
    public UnionFind1(int size) {
        id  = new int[size];
        for (int i = 0; i < id.length; i ++) {
            //��ʾÿһ��Ԫ�������ڲ�ͬ�ļ���
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * ����Ԫ��p��Ӧ�ı��
     * @param p ������Ԫ��
     * @return ���ر��
     */
    private int find(int p) {
        if (p < 0 && p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * �ϲ�Ԫ��p��Ԫ��q�ļ���
     * @param p ���ϲ�Ԫ��
     * @param q ���ϲ�Ԫ��
     */
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i ++) {
            if (id[i] ==pID) {
                id[i] = qID;
            }
        }

    }

}
