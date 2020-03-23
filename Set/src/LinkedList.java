import jdk.jshell.spi.SPIResolutionException;

public class LinkedList<E> {
    /**
    Node class设置为内部类，且为private class，外部成员无法访问内部类
     */
    private class Node{
        public E e;
        public Node next;
        //将e和next设置为public，在linked list中可以随意访问这两个变量
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

    //设置虚拟节点dummyhead,不存放任何内容
    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
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
    public boolean isEmpty(){
        return size == 0;
    }



    /**
     * 在链表中某一位置插入元素
     */
    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;

//        if (index == 0) {
//            addFirst(e);
//        } else {
//            Node prev = head;
//            for (int i = 0; i < index - 1; i ++) {
//                prev = prev.next;
//            }
//
////            Node node = new Node(e);
////            node.next = prev.next;
////            prev.next = node;
//
//            prev.next = new Node(e, prev.next);
//            size++;
//
//        }
    }

    /**
     * 在链表头添加元素e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);
//        size++;
        add(0, e);
    }

    /**
     * 在链表末尾添加元素
     */
    public void addLast(E e){
//        Node node = new Node(e);
//        node.next = null;
        add(size, e);
    }

    /**
     * 获得链表中第index(0-based)个位置元素
     */
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i<index; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 更新链表中第index(0-based)个元素，更新index处的元素为e
     */
    public void set(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找联保中是否存在e
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     *从链表中删除index(0-based)位置元素，返回删除元素
     */
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        //找出删除位置的链表节点
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素
     * @return 返回删除元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表中最后一个元素
     * @return 返回尾节点
     */
    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
