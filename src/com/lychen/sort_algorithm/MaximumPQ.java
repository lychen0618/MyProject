package com.lychen.sort_algorithm;

public class MaximumPQ {
    public Heap a;

    public MaximumPQ() {
    }

    public MaximumPQ(Heap a) {
        this.a = a;
        a.buildMaxHeap();
    }

    public Comparable getMaximum() {
        return a.arr[0];
    }

    public Comparable extractMaximum() {
        if (a.heapSize < 0) {
            System.out.println("No element");
            return -1;
        }
        Comparable max = a.arr[0];
        a.arr[0] = a.arr[a.heapSize];
        a.heapSize--;
        a.maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, Comparable key) {
        a.arr[i] = key;
        while (i > 0 && a.arr[(i - 1) / 2].compareTo(a.arr[i]) < 0) {
            Comparable temp = a.arr[(i - 1) / 2];
            a.arr[(i - 1) / 2] = a.arr[i];
            a.arr[i] = temp;
            i = (i - 1) / 2;
        }
    }

    public void insert(Comparable key) {
        a.heapSize++;
        increaseKey(a.heapSize, key);
    }
}
