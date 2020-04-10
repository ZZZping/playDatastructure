public class SegnmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;
    public SegnmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;

        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; ++ i) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        bulidSegnmentTree(0, 0, data.length - 1);
    }

    /**
     *在treeIndex处创建区间[l,r]的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void bulidSegnmentTree(int treeIndex, int l, int r){
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid  = l + (r - l) / 2;

        bulidSegnmentTree(leftTreeIndex, l, mid);

        bulidSegnmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    /**
     * 查询[queryL, queryR]的值
     * @param queryL 左边界
     * @param queryR 右边界
     * @return 返回查询值
     */
    public E query(int queryL, int queryR){
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeID为根的线段树中[l,r]的范围里，搜索区间[queryL,queryR]的值
     * @param treeIndex 根节点
     * @param l 线段树左边界
     * @param r 线段树右边界
     * @param queryL 查询左边界
     * @param queryR 查询右边界
     * @return 返回查询结果
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex,mid + 1, r, mid + 1, queryR);
        return merger.merger(leftResult, rightResult);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i ++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}
