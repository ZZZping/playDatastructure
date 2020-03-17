public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        /**
         * 用户传来元素e
         * @param e 用户传来的元素
         */
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    //根节点
    private Node root;
    //二叉树的容量
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


}
