public class UnionFind1 implements UF {
    private int[] id;
    public UnionFind1(int size) {
        id  = new int[size];
        for (int i = 0; i < id.length; i ++) {
            //表示每一个元素所属于不同的集合
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p对应的编号
     * @param p 带查找元素
     * @return 返回编号
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
     * 合并元素p和元素q的集合
     * @param p 待合并元素
     * @param q 待合并元素
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
