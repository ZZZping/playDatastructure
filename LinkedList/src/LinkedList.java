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
}
