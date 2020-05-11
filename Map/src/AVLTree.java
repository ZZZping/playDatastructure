import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

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
     * �ж��Ƿ�ΪBST
     * @return �����жϽ��
     */
    public boolean isBST() {
        //ʹ�������������BSTʱ���������ʱ��˳������
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
     * �ж���rootΪ���ڵ�Ķ������Ƿ�Ϊƽ�������
     * @param node ���жϽڵ�
     * @return �����Ƿ�Ϊƽ�������
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * ��ýڵ�node�ĸ߶�
     * @param node �ڵ�
     * @return ���ؽڵ�߶�
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * ��ýڵ��ƽ������
     * @param node �ڵ�
     * @return ����ƽ������
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * ����ת����
     * @param y ������ƽ��������Ľڵ�
     * @return ������ת��ĸ��ڵ�
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        //����ת
        x.right = y;
        y.left = T3;
        //����height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * ����ת
     * @param y ��ƽ��ڵ�
     * @return ��������ת��ĸ��ڵ�
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
        //����߶�
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //���ƽ������
        int balacneFctor = getBalanceFactor(node);
//        if (Math.abs(balacneFctor) > 1) {
//            System.out.println("unbalance : " + balacneFctor);
//        }

        //ƽ��ά��
        //1.����תLL
        if (balacneFctor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //2.����תRR
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

    private Node mininum(Node node){
        if (node.left == null) {
            return node;
        }
        return mininum(node.left);
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
        //ʹ��retNode���潫Ҫ���صĽڵ�
        //ʹ��retNode�����л����retNode����ά��
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            //������������ǻ����
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = node;
            } else {
            //successor��node�������е���Сֵ
            Node successor = mininum(node.right);
            successor.right = remove(node.right, successor.key);
            successor.left = node.left;
            node.left = node.right = null;
            retNode = successor;
            }
        }
        //����ɾ���ڵ�Ϊ��ʱ��ֱ�ӷ��أ�����ά������ƽ����
        if (retNode == null) {
            return null;
        }
        //����߶�
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        //���ƽ������
        int balacneFctor = getBalanceFactor(retNode);

        //ƽ��ά��
        //1.����תLL
        if (balacneFctor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //2.����תRR
        if (balacneFctor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //3.LR
        if (balacneFctor > 1 && getBalanceFactor(retNode.right) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //4.RL
        if (balacneFctor < -1 && getBalanceFactor(retNode.left) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;

    }

    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)) {
            System.out.println("Total words: " + words.size());
            AVLTree<String ,Integer> map = new AVLTree<>();
            for (String word: words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of Pride: " + map.get("pride"));
            System.out.println("Frequency of Prejudice: " + map.get("prejudice"));
            System.out.println("isBST: " + map.isBST());
            System.out.println("isBalance: " + map.isBalance());
            for (String word : words) {
                map.remove(word);
                if (!map.isBST() || !map.isBalance()) {
                    throw new RuntimeException("error");
                }
            }
        }
    }
}