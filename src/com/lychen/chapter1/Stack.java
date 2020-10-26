package com.lychen.chapter1;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node first;
    int N;

    private class Node {
        T value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T x) {
        Node oldFirst = first;
        first = new Node();
        first.value = x;
        first.next = oldFirst;
        N++;
    }

    public T pop() {
        T value = first.value;
        first = first.next;
        N--;
        return value;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

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
