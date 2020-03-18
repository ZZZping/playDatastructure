import org.jetbrains.annotations.NotNull;

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

    /**
     * 像节点中添加元素e
     * @param e 插入的元素
     */
    public void add(E e){
//        if (root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }
        //在递归函数中以及判断了root为空的情况
        root = add(root, e);
    }

    /**
     * 递归函数，向节点node中传入元素e,返回插入节点后BST的root
     * @param node 目标节点，在插入时，BST的root节点在不断变化
     * @param e 传入的元素
     */
    private Node add(@NotNull Node node, E e) {

        //递归终止条件
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            //不能使用comparable
//            //插入元素比root小，且左孩子值为空，创建新的左孩子
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            //插入的值比root大，且有孩子为空，创建新的右孩子
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
        if (node == null) {
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            //插入的元素比root节点小，插入到左子树
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            //插入的元素比root元素大，插入到右子树
            node.right = add(node.right, e);
        }
        return node;
    }
}
