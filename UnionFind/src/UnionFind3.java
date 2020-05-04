public class UnionFind3 implements UF{
    private int[] parent;
    //sz[i]��ʾ��iΪ���ļ�����Ԫ�صĸ���
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        //�ҵ��ڵ�p�ĸ��ڵ�
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pROOT = find(p);
        int qRoot = find(q);

        if (pROOT == qRoot) {
            return;
        }
        if (sz[pROOT] < sz[qRoot]){
            parent[pROOT] = qRoot;
            sz[qRoot] += sz[pROOT];
        } else {
            parent[qRoot] = pROOT;
            sz[pROOT] += sz[qRoot];
        }

    }
}
