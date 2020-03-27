public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        /**
         * �ڵ㺯��
         *
         * @param key   map�е�keyֵ
         * @param value key��Ӧ��value
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;
    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size ++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            //�����Ԫ�ر�root�ڵ�С�����뵽������
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            //�����Ԫ�ر�rootԪ�ش󣬲��뵽������
            node.right = add(node.right, key, value);
        } else {
            //key.compareto(node.key)==0
            node.value = value;
        }
        return node;
    }

    /**
     * ������nodeΪ���ڵ��BST�У�key���ڵĽڵ�
     * @param node ��nodeΪ�ڵ�
     * @param key Ѱ��key�ڵ�
     * @return �����ҵ��Ľڵ�
     */
    private Node getNode(Node node, K key){
        if (node ==null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    

}
