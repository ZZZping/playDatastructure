import java.nio.file.NotDirectoryException;
import java.util.ArrayList;

public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

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
            //初始化时默认树的结点颜色为红色
            color = RED;
        }
    }
    private Node root;
    private int size;
    public RBTree(){
        root = null;
        size = 0;
    }

    /**
     * 判断结点node的颜色
     * @param node 待判断结点
     * @return 返回节点颜色
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;

        //维持节点颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色翻转
     * @param node 待翻转结点
     */
    private void flipColors(Node node) {
        //1.将根结点设为红色
        node.color = RED;
        //2.将根结点的左右子结点设为黑色
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        //右旋转
        //将node与结点x脱离关系
        node.left = x.right;
        x.right = node;
        //维护结点颜色
        x.color = node.color;
        node.color = RED;

        return x;

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
        //向红黑树中添加元素，并将根节点设为红色
        root.color = BLACK;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size ++;
            //如果刚开始红黑树中没有元素时，添加一个红色结点
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            //插入的元素比root节点小，插入到左子树
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            //插入的元素比root元素大，插入到右子树
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        //维护红黑树性质
        //三个条件不是互斥条件
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
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

    private Node mininum(Node node){
        if (node.left == null) {
            return node;
        }
        return mininum(node.left);
    }

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

    @Override
    public V remove(K key){
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            //待删除结点在左子树上
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            //待删除结点在右子树上
            node.right = remove(node.right, key);
            return node;
        } else {
            //e == node.e
            //待删除结点的左孩子为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除结点的右孩子为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return node;
            }
            //待删除节点左右均不为空
            //找到比待删除节点大的最小节点，即待删除结点右子树的最小节点
            //使用找到的节点代替待删除结点
            //先找到待删除结点右子树的最小节点
            Node successor = mininum(node.right);
            //将代替节点与待删除结点的右子树相连接
            successor.right = removeMin(node.right);
            //将替代节点与原来节点的左子树连接
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
            //不需要维护size大小，在removeMin中维护了size大小
        }
    }

    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)) {
            System.out.println("Total words: " + words.size());
            RBTree<String ,Integer> rbtree = new RBTree<>();
            for (String word: words) {
                if (rbtree.contains(word)) {
                    rbtree.set(word, rbtree.get(word) + 1);
                } else {
                    rbtree.add(word, 1);
                }
            }
            System.out.println("Total different words: " + rbtree.getSize());
            System.out.println("Frequency of Pride: " + rbtree.get("pride"));
            System.out.println("Frequency of Prejudice: " + rbtree.get("prejudice"));
        }
    }

}

