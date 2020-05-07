import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

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
            height = 1;
        }
    }
    private Node root;
    private int size;

    public AVLTree(){
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

    /**
     * 判断是否为BST
     * @return 返回判断结果
     */
    public boolean isBST() {
        //使用中序遍历遍历BST时，遍历结果时按顺序排列
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i ++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return ;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isBalance() {
        return isBalanced(root);
    }

    /**
     * 判断以root为根节点的二叉树是否为平衡二叉树
     * @param node 待判断节点
     * @return 返回是否为平衡二叉树
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFctor = getBalanceFactor(node);
        if (Math.abs(balanceFctor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * 获得节点node的高度
     * @param node 节点
     * @return 返回节点高度
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获得节点的平衡因子
     * @param node 节点
     * @return 返回平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 右旋转操作
     * @param y 不满足平衡二叉树的节点
     * @return 返回旋转后的根节点
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        //右旋转
        x.right = y;
        y.left = T3;
        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 左旋转
     * @param y 不平衡节点
     * @return 返回左旋转后的根节点
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;
        x.left = y;
        y.right = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        //计算高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //获得平衡因子
        int balacneFctor = getBalanceFactor(node);
//        if (Math.abs(balacneFctor) > 1) {
//            System.out.println("unbalance : " + balacneFctor);
//        }

        //平衡维护
        //1.右旋转LL
        if (balacneFctor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //2.左旋转RR
        if (balacneFctor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //3.LR
        if (balacneFctor > 1 && getBalanceFactor(node.right) <= 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //4.RL
        if (balacneFctor < -1 && getBalanceFactor(node.left) >=0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
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
            node.right = null;
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
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return node;
            }
            Node successor = mininum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

//    public static void main(String[] args) {
//        System.out.println("Pride and prejudice");
//        ArrayList<String> words = new ArrayList<>();
//        if (FileOperation.readFile("pride-and-prejudice.txt",words)) {
//            System.out.println("Total words: " + words.size());
//            AVLTree<String ,Integer> map = new AVLTree<>();
//            for (String word: words) {
//                if (map.contains(word)) {
//                    map.set(word, map.get(word) + 1);
//                } else {
//                    map.add(word, 1);
//                }
//
//            }
//            System.out.println("Total different words: " + map.getSize());
//            System.out.println("Frequency of Pride: " + map.get("pride"));
//            System.out.println("Frequency of Prejudice: " + map.get("prejudice"));
//        }
//    }
}
