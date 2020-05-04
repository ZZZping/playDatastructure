import java.io.FileInputStream;

public class UnionFind2 implements UF {
    //parent[i]��ʾ��i��Ԫ��ָ��Ľڵ�
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
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
        parent[pROOT] = qRoot;
    }
}
