package com.lychen.sort_algorithm;

public class Heap<T extends Comparable<T>> {
    public T[] arr;
    public int heapSize;

    public Heap() {
    }

    public Heap(T[] a) {
        arr = a;
        heapSize = -1;
    }

    public void maxHeapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l <= heapSize && arr[l].compareTo(arr[i]) > 0) largest = l;
        if (r <= heapSize && arr[r].compareTo(arr[largest]) > 0) largest = r;
        if (largest != i) {
            T temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        heapSize = arr.length - 1;
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            maxHeapify(i);
        }
    }
}
