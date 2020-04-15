package MST.Kurskal;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E> {
    //bag的初始节点
    private Node<E> first;
    //size of bag
    private int size;

    private static class Node<E> {
        private E e;
        private Node<E> next;
    }

    /**
     * 初始化一个bag
     */
    public Bag() {
        first = null;
        size = 0;
    }

    /**
     * 判断bag是否为空
     * @return 返回是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得bag大小
     * @return 返回bag容量
     */
    public int size() {
        return size;
    }

    /**
     * 向bag中添加元素e
     * @param e 被添加元素
     */
    public void add(E e) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.e = e;
        first.next = oldfirst;
        //控制bag容量
        size ++;
    }

    public Iterator<E> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<E> {
        private Node<E> cur;
        public LinkedIterator(Node<E> first) {
            cur = first;
        }
        public boolean hasNext() {
            return cur != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E e = cur.e;
            cur = cur.next;
            return e;
        }
    }

}
