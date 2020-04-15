package MST.Kurskal;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E> {
    //bag�ĳ�ʼ�ڵ�
    private Node<E> first;
    //size of bag
    private int size;

    private static class Node<E> {
        private E e;
        private Node<E> next;
    }

    /**
     * ��ʼ��һ��bag
     */
    public Bag() {
        first = null;
        size = 0;
    }

    /**
     * �ж�bag�Ƿ�Ϊ��
     * @return �����Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ���bag��С
     * @return ����bag����
     */
    public int size() {
        return size;
    }

    /**
     * ��bag�����Ԫ��e
     * @param e �����Ԫ��
     */
    public void add(E e) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.e = e;
        first.next = oldfirst;
        //����bag����
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
