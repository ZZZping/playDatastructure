import org.jetbrains.annotations.NotNull;

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
    private Node add(@NotNull Node node, E e) {

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
}
