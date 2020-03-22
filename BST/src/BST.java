import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    private Node add(Node node, E e) {

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

    /**
     * 查看二分搜索树中是否包含元素e
     * @param e 索索地目的元素
     * @return return调用地递归函数
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 递归函数
     * @param node 从node结点开始
     * @param e 搜索元素e
     * @return 返回bool值
     */
    private boolean contains(Node node, E e){

        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            //e比node节点元素小，将e与node左子树节点比较
            return contains(node.left, e);
        } else {
            //e比node节点元素大，将e与node右子树节点比较
            return contains(node.right, e);
        }

    }

    /**
     * 前序遍历二叉树
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，先打印root节点元素，再打印左孩子节点元素，最后打印右孩子节点元素
     * @param node node为根节点
     */
    private void preOrder(Node node){
//        if (node == null) {
//            return;
//        }
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    /**
     * 使用stack进行BST的非递归实现
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //cur节点是当前要访问的节点
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 先打印左孩子元素，再打印root节点元素，最后打印右孩子节点元素
     * @param node root节点
     */
    private void inOrder(Node node){
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * 内存释放方面
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历，先打印右孩子节点元素，再打印左孩子节点元素，最后打印root节点元素
     * @param node root节点
     */
    private void postOrder(Node node){
        if (node != null) {
            postOrder(node.right);
            postOrder(node.left);
            System.out.println(node.e);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 返回BST中的最小元素
     * @return 返回最小元素
     */
    public E mininum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return mininum(root).e;
    }

    /**
     * mininum递归函数
     * @param node root节点
     * @return return调用递归函数
     */
    private Node mininum(Node node){
        if (node.left == null) {
            return node;
        }
        return mininum(node.left);
    }

    /**
     * 返回BST中最大元素
     * @return 返回最大元素
     */
    public E maxnum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxnum(root).e;
    }

    /**
     * 递归函数
     * @param node root节点
     * @return return调用递归函数
     */
    private Node maxnum(Node node){
        if (node.right == null) {
            return node;
        }
        return maxnum(node);
    }

    /**
     * 删除BST中最小值
     * @return 返回最小值
     */
    public E removeMin(){
        E ret = mininum();
        //将新的root节点赋值给root节点
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的BST中最小节点，返回删除节点后新的BST中的root节点
     * @param node node节点
     * @return 返回新的BST的root节点
     */
    private Node removeMin(Node node){
        if (node.left == null) {
            Node rightNode = node.right;
            //删除节点
            node.right = null;
            //控制BST容量
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除BST中最大元素
     * @return 返回新的root节点
     */
    public E removeMax(){
        E ret = maxnum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 返回以node为根节点的BST的最大值
     * @param node 以node为根节点
     * @return 返回新的根节点
     */
    private Node removeMax(Node node){
        if (node.left == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMin(node);
        return node;
    }

    /**
     * 删除BST中任意节点
     * @param e 待删除元素
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * 使用Hibbrad Deletion算法实现递归函数
     * @param node 待删除节点
     * @param e 待删除元素
     * @return 返回新的BST
     */
    private Node remove(Node node, E e){
        if (node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            //待删除结点在左子树上
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            //待删除结点在右子树上
            node.right = remove(node.right, e);
            return node;
        } else {
            //e == node.e
            //待删除结点的左孩子为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除结点的右孩子为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return node;
            }
            //待删除节点左右均不为空
            //找到比待删除节点大的最小节点，即待删除结点右子树的最小节点
            //使用找到的节点代替待删除结点
            //先找到待删除结点右子树的最小节点
            Node successor = mininum(node.right);
            //将代替节点与待删除结点的右子树相连接
            successor.right = removeMin(node.right);
//            size ++;
            //将替代节点与原来节点的左子树连接
            successor.left = node.left;
            node.left = node.right = null;
//            size --;
            return successor;
            //不需要维护size大小，在removeMin中维护了size大小
        }


    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1 , res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i =0; i < depth; i ++) {
            res.append("--");
        }
        return res.toString();
    }
}
