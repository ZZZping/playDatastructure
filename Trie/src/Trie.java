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

    //根节点
    private Node root;
    //Trie的容量
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得容量
     * @return 返回容量
     */
    public int getSize() {
        return size;
    }

    /**
     * 向trie中添加元素
     * @param world 添加元素word
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
     * 查询是否含有字符word
     * @param word 带查询单词
     * @return 返回是否存在
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
