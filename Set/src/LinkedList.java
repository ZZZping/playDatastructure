import jdk.jshell.spi.SPIResolutionException;

public class LinkedList<E> {
    /**
    Node class����Ϊ�ڲ��࣬��Ϊprivate class���ⲿ��Ա�޷������ڲ���
     */
    private class Node{
        public E e;
        public Node next;
        //��e��next����Ϊpublic����linked list�п��������������������
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

    //��������ڵ�dummyhead,������κ�����
    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * ��ȡ������Ԫ�ظ���
     */
    public int getSize(){
        return size;
    }

    /**
     * �ж������Ƿ�Ϊ��
     */
    public boolean isEmpty(){
        return size == 0;
    }



    /**
     * ��������ĳһλ�ò���Ԫ��
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
     * ������ͷ���Ԫ��e
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
     * ������ĩβ���Ԫ��
     */
    public void addLast(E e){
//        Node node = new Node(e);
//        node.next = null;
        add(size, e);
    }

    /**
     * ��������е�index(0-based)��λ��Ԫ��
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
     * ��ȡ�����һ��Ԫ��
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * ��ȡ�������һ��Ԫ��
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * ���������е�index(0-based)��Ԫ�أ�����index����Ԫ��Ϊe
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
     * �����������Ƿ����e
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
     *��������ɾ��index(0-based)λ��Ԫ�أ�����ɾ��Ԫ��
     */
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        //�ҳ�ɾ��λ�õ�����ڵ�
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
     * ��������ɾ����һ��Ԫ��
     * @return ����ɾ��Ԫ��
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * ɾ�����������һ��Ԫ��
     * @return ����β�ڵ�
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
