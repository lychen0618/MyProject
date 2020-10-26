package com.lychen.sort_algorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

//在创建自己的数据类型时，需要实现Comparable接口，即实现一个compareTo()方法来定义目标类型对象的自然次序
public class Sort {
    public static void printArray(Comparable[] a) {
        for (int i = 0; i < a.length; ++i) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    // 插入排序
    public static void insertSort(Comparable[] a) {
        for (int j = 1; j < a.length; ++j) {
            Comparable temp = a[j];
            int i = j - 1;
            while (i >= 0 && a[i].compareTo(temp) > 0) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = temp;
        }
    }

    // 选择排序
    public static void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; ++i) {
            int min = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[min].compareTo(a[j]) > 0) min = j;
            }
            Comparable temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    // 归并排序
    private static Comparable[] helpArr;

    private static void merge(Comparable[] a, int l, int mid, int h) {
        int i = l, j = mid + 1;
        for (int k = l; k <= h; ++k) {
            helpArr[k] = a[k];
        }
        for (int k = l; k <= h; ++k) {
            if (i > mid) a[k] = helpArr[j++];
            else if (j > h) a[k] = helpArr[i++];
            else if (helpArr[i].compareTo(helpArr[j]) <= 0) a[k] = helpArr[i++];
            else a[k] = helpArr[j++];
        }
    }

    public static void mergeSort(Comparable[] a, int l, int h) {
        if (h <= l) return;
        int mid = l + (h - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, h);
        merge(a, l, mid, h);
    }

    // 快速排序
    private static int partition(Comparable[] a, int p, int r) {
        Comparable x = a[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (a[j].compareTo(x) <= 0) {
                i++;
                Comparable temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        Comparable temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        return i + 1;
    }

    public static void quickSort(Comparable[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    // 堆排序
    public static void heapSort(Heap a) {
        a.buildMaxHeap();
        for (int i = a.arr.length - 1; i > 0; --i) {
            Comparable temp = a.arr[i];
            a.arr[i] = a.arr[0];
            a.arr[0] = temp;
            a.heapSize--;
            a.maxHeapify(0);
        }

    }

    public static void main(String[] args) {
        int N = 10;
        Double[] d = new Double[N];
        for (int i = 0; i < N; ++i) {
            d[i] = StdRandom.uniform();
        }
        printArray(d);
        Double[] temp = d.clone();
        insertSort(temp);
        printArray(temp);
        temp = d.clone();
        selectSort(temp);
        printArray(temp);

        temp = d.clone();
        helpArr = new Comparable[temp.length];
        mergeSort(temp, 0, temp.length - 1);
        printArray(temp);

        temp = d.clone();
        quickSort(temp, 0, temp.length - 1);
        printArray(temp);

        Heap a = new Heap(d.clone());
        heapSort(a);
        printArray(a.arr);

        StdOut.println("--------");
        MaximumPQ pq = new MaximumPQ(new Heap(d.clone()));
        printArray(pq.a.arr);
        StdOut.println(pq.getMaximum());
        pq.increaseKey(4, 0.9);
        printArray(pq.a.arr);
        StdOut.println(pq.extractMaximum());
        printArray(pq.a.arr);
        pq.insert(1.2);
        printArray(pq.a.arr);
    }
}
