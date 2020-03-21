import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        /**
         * �û�����Ԫ��e
         * @param e �û�������Ԫ��
         */
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    //���ڵ�
    private Node root;
    //������������
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * �ж϶������Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ��ڵ������Ԫ��e
     * @param e �����Ԫ��
     */
    public void add(E e){
//        if (root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }
        //�ڵݹ麯�����Լ��ж���rootΪ�յ����
        root = add(root, e);
    }

    /**
     * �ݹ麯������ڵ�node�д���Ԫ��e,���ز���ڵ��BST��root
     * @param node Ŀ��ڵ㣬�ڲ���ʱ��BST��root�ڵ��ڲ��ϱ仯
     * @param e �����Ԫ��
     */
    private Node add(Node node, E e) {

        //�ݹ���ֹ����
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            //����ʹ��comparable
//            //����Ԫ�ر�rootС��������ֵΪ�գ������µ�����
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            //�����ֵ��root�����к���Ϊ�գ������µ��Һ���
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
        if (node == null) {
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            //�����Ԫ�ر�root�ڵ�С�����뵽������
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            //�����Ԫ�ر�rootԪ�ش󣬲��뵽������
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * �鿴�������������Ƿ����Ԫ��e
     * @param e ������Ŀ��Ԫ��
     * @return return���õصݹ麯��
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * �ݹ麯��
     * @param node ��node��㿪ʼ
     * @param e ����Ԫ��e
     * @return ����boolֵ
     */
    private boolean contains(Node node, E e){

        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            //e��node�ڵ�Ԫ��С����e��node�������ڵ�Ƚ�
            return contains(node.left, e);
        } else {
            //e��node�ڵ�Ԫ�ش󣬽�e��node�������ڵ�Ƚ�
            return contains(node.right, e);
        }

    }

    /**
     * ǰ�����������
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * ǰ�������nodeΪ���Ķ������������ȴ�ӡroot�ڵ�Ԫ�أ��ٴ�ӡ���ӽڵ�Ԫ�أ�����ӡ�Һ��ӽڵ�Ԫ��
     * @param node nodeΪ���ڵ�
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
     * ʹ��stack����BST�ķǵݹ�ʵ��
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //cur�ڵ��ǵ�ǰҪ���ʵĽڵ�
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
     * �������
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * �ȴ�ӡ����Ԫ�أ��ٴ�ӡroot�ڵ�Ԫ�أ�����ӡ�Һ��ӽڵ�Ԫ��
     * @param node root�ڵ�
     */
    private void inOrder(Node node){
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    /**
     * �������
     * �ڴ��ͷŷ���
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * ����������ȴ�ӡ�Һ��ӽڵ�Ԫ�أ��ٴ�ӡ���ӽڵ�Ԫ�أ�����ӡroot�ڵ�Ԫ��
     * @param node root�ڵ�
     */
    private void postOrder(Node node){
        if (node != null) {
            postOrder(node.right);
            postOrder(node.left);
            System.out.println(node.e);
        }
    }

    /**
     * �������
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
