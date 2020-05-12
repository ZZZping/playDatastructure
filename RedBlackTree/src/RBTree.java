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
            //��ʼ��ʱĬ�����Ľ����ɫΪ��ɫ
            color = RED;
        }
    }
    private Node root;
    private int size;
    public RBTree(){
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

    private Node mininum(Node node){
        if (node.left == null) {
            return node;
        }
        return mininum(node.left);
    }

    private Node removeMin(Node node){
        if (node.left == null) {
            Node rightNode = node.right;
            //ɾ���ڵ�
            node.right = null;
            //����BST����
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
            //��ɾ���������������
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            //��ɾ���������������
            node.right = remove(node.right, key);
            return node;
        } else {
            //e == node.e
            //��ɾ����������Ϊ��
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //��ɾ�������Һ���Ϊ��
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return node;
            }
            //��ɾ���ڵ����Ҿ���Ϊ��
            //�ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���������������С�ڵ�
            //ʹ���ҵ��Ľڵ�����ɾ�����
            //���ҵ���ɾ���������������С�ڵ�
            Node successor = mininum(node.right);
            //������ڵ����ɾ������������������
            successor.right = removeMin(node.right);
//            size ++;
            //������ڵ���ԭ���ڵ������������
            successor.left = node.left;
            node.left = node.right = null;
//            size --;
            return successor;
            //����Ҫά��size��С����removeMin��ά����size��С
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

