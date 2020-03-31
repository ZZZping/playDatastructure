import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        /**
         * �ڵ㺯��
         * @param key map�е�keyֵ
         * @param value key��Ӧ��value
         * @param next next�ڵ�
         */
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * ����һ��keyֵ
         * @param key ����key
         */
        public Node(K key){
            this(key, null, null);
        }

        /**
         * ���ӵ�Ϊ��
         */
        public Node(){
            this(null,null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedListMap(){
        dummyHead = new Node();
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

    private Node getNode(K key){
        //curָ��������һ���ڵ�
        Node cur = dummyHead.next;
        while (cur !=  null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        return getNode(key) != null;
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value){
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        } else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V newValue){
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public V remove(K key){
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        //ɾ���ڵ�
        if (prev.next != null) {
            //delNodeΪ��ɾ�����
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        //��prev.nextΪnullʱ������null
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)) {
            System.out.println("Total words: " + words.size());
            LinkedListMap<String ,Integer> map = new LinkedListMap<>();
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
        }
    }

}