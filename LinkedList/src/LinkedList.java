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
}
