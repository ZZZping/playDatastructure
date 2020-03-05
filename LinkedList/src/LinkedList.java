public class LinkedList<E> {
    /**
    Node class设置为内部类，且为private class，外部成员无法访问内部类
     */
    private class Node{
        public E e;
        public Node next;
        //将e和next设置为public，在linkedlist中可以随意访问这两个变量
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * 获取链表中元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty9(){
        return size == 0;
    }

    /**
     * 在链表头添加元素e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表中某一位置插入元素
     */
    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i ++) {
                prev = prev.next;
            }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);
            size++;

        }
    }

    /**
     * 在链表末尾添加元素
     */
    public void addLast(E e){
//        Node node = new Node(e);
//        node.next = null;
        add(size, e);
    }
}
