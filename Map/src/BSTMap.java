public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        /**
         * 节点函数
         *
         * @param key   map中的key值
         * @param value key对应的value
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
            //插入的元素比root节点小，插入到左子树
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            //插入的元素比root元素大，插入到右子树
            node.right = add(node.right, key, value);
        } else {
            //key.compareto(node.key)==0
            node.value = value;
        }
        return node;
    }

    /**
     * 返回以node为根节点的BST中，key所在的节点
     * @param node 以node为节点
     * @param key 寻找key节点
     * @return 返回找到的节点
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
