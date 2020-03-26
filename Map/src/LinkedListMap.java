import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        /**
         * 节点函数
         * @param key map中的key值
         * @param value key对应的value
         * @param next next节点
         */
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * 添加一个key值
         * @param key 添加key
         */
        public Node(K key){
            this(key, null, null);
        }

        /**
         * 添加的为空
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
        //cur指向链表第一个节点
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
        //删除节点
        if (prev.next != null) {
            //delNode为待删除结点
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        //当prev.next为null时，返回null
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
