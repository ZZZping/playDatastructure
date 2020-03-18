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
        if (root == null) {
            root = new Node(e);
            size ++;
        } else {
            add(root, e);
        }
    }

    /**
     * �ݹ麯������ڵ�node�д���Ԫ��e
     * @param node Ŀ��ڵ㣬�ڲ���ʱ��BST��root�ڵ��ڲ��ϱ仯
     * @param e �����Ԫ��
     */
    private void add(Node node, E e) {

        //�ݹ���ֹ����
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            //����ʹ��comparable
            //����Ԫ�ر�rootС��������ֵΪ�գ������µ�����
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            //�����ֵ��root�����к���Ϊ�գ������µ��Һ���
            node.right = new Node(e);
            size ++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            //�����Ԫ�ر�root�ڵ�С�����뵽������
            add(node.left, e);
        } else {
            //�����Ԫ�ر�rootԪ�ش󣬲��뵽������
            add(node.right, e);
        }
    }


}
