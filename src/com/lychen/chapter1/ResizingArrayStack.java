package com.lychen.chapter1;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] arr = (T[]) new Object[1];
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        //创建泛型数组是不被允许的，所以写成下面的方式
        T[] newArr = (T[]) new Object[max];
        for (int i = 0; i < N; ++i) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void push(T t) {
        if (N == arr.length) resize(2 * N);
        arr[N++] = t;
    }

    public T pop() {
        T t = arr[--N];
        //保存一个不需要的对象的引用称为游离，下面是为了避免游离
        arr[N] = null;
        if (N > 0 && N == arr.length / 4) resize(arr.length / 2);
        return t;

    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;

        public boolean hasNext() {
            return i != 0;
        }

        public T next() {
            return arr[i];
        }

        public void remove() {

        }
    }
}
