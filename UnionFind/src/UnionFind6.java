public class UnionFind6 implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
            rank[i] = 1;
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
        while (p != parent[p]) {
            //路径压缩
            //将节点p指向节点p的根节点的根节点
            parent[p] = parent[parent[p]];
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
        if (rank[pROOT] < rank[qRoot]){
            parent[pROOT] = qRoot;
        } else if (rank[qRoot] < rank[pROOT]) {
            parent[qRoot] = parent[pROOT];
        } else {
            parent[qRoot] = pROOT;
            rank[pROOT] += 1;
        }

    }
}
