public class LinkedList<E> {
    /**
    Node class����Ϊ�ڲ��࣬��Ϊprivate class���ⲿ��Ա�޷������ڲ���
     */
    private class Node{
        public E e;
        public Node next;
        //��e��next����Ϊpublic����linkedlist�п��������������������
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
     * ��ȡ������Ԫ�ظ���
     */
    public int getSize(){
        return size;
    }

    /**
     * �ж������Ƿ�Ϊ��
     */
    public boolean isEmpty9(){
        return size == 0;
    }

    /**
     * ������ͷ���Ԫ��e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    /**
     * ��������ĳһλ�ò���Ԫ��
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
     * ������ĩβ���Ԫ��
     */
    public void addLast(E e){
//        Node node = new Node(e);
//        node.next = null;
        add(size, e);
    }
}
