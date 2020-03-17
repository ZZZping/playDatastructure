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


}
