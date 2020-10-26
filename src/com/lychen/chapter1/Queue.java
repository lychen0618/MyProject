package com.lychen.chapter1;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node head, tail;
    private int N;

    private class Node {
        T value;
        Node next;
    }

    public void enqueue(T value) {
        Node newN = new Node();
        newN.value = value;
        if (N == 0) {
            head = newN;
            tail = newN;
        } else {
            tail.next = newN;
            tail = newN;
        }
        N++;
    }

    public T dequeue() {
        T value = head.value;
        if (N == 1) head = tail = null;
        else head = head.next;
        N--;
        return value;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }

        public void remove() {

        }
    }
}
