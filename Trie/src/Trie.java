import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    //���ڵ�
    private Node root;
    //Trie������
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * �������
     * @return ��������
     */
    public int getSize() {
        return size;
    }

    /**
     * ��trie�����Ԫ��
     * @param world ���Ԫ��word
     */
    public void add(String world) {
        Node cur = root;
        for (int i = 0; i < world.length(); i ++) {
            char c = world.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * ��ѯ�Ƿ����ַ�word
     * @param word ����ѯ����
     * @return �����Ƿ����
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

}
