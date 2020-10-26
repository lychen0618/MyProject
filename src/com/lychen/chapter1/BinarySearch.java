package com.lychen.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int x, int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int size = StdIn.readInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = StdIn.readInt();
        }
        Arrays.sort(arr);
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            StdOut.println(rank(x, arr));
        }
    }
}
