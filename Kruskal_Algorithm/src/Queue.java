import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int n;

    private static class Node<E> {
        private E e;
        private Node<E> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("MST.Kurskal.Queue underflow");
        return first.e;
    }

    public void enqueue(E e) {
       Node<E> oldlast = last;
        last = new Node<E>();
        last.e = e;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
        n++;
    }

    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("MST.Kurskal.Queue underflow");
        E e = first.e;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return e;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E e : this) {
            s.append(e);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<E> iterator()  {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedIterator(Node<E> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E e = current.e;
            current = current.next;
            return e;
        }
    }

}
