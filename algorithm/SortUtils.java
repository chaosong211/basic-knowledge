
package com.example.demo.utils;

import java.util.Arrays;

public class SortUtils {


    public static void bubbleSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        for (int i=0; i < n - 1; i++) {
            boolean flag = false;
            for (int j=0; j < n-i-1; j++) {

                int temp = 0;
                if(a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            System.out.println(i + ":" + Arrays.toString(a));
            if (!flag) {
                break;
            }
        }
    }

    public static void bubbleSortImproved(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        // the last position exchanged
        int lastExchange = 0;
        // the border that needs comparison
        int border = n - 1;
        for (int i = 0; i < n - 1; i++) {
            // record if exchanged
            boolean flag = false;
            for (int j = 0; j < border; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                    // update the last exchanged position
                    lastExchange = j;
                }
            }
            System.out.println(i + ":" + Arrays.toString(a));
            if (!flag) {
                break;
            }
            border = lastExchange;
        }

    }

    // insert data into an array in order
    public static void insertionSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {

            int j = i - 1;
            int temp = a[i];
            for (; j >= 0; --j) {
                if (temp < a[j]) {
                    a[j+1] = a[j];
                } else {
                  break;
                }
            }
            a[j+1] = temp;
        }

    }

    // insert data into an interval in order
    public static void insertSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        int i = 0;
        for (; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
        System.out.println(i);
    }


    // similar to insertionSort, selectionSort will pick the smallest one from
    // unordered interval, then insert into the tail of the ordered one
    // [11, 2, 3, 10, 5, 9]
    public static void selectionSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // exchange the current with minimum one
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }


    }

    public static boolean validate(int[] a) {

        if (a.length <= 1) {
            return true;
        }
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int n = 50;
        int a[] = ArrayGenerator.generateIntArray(n);
        System.out.println(Arrays.toString(a));
        //bubbleSortImproved(a, n);
        //insertSort(a, n);
        selectionSort(a, n);
        System.out.println(Arrays.toString(a));
        System.out.println(validate(a));
    }

}
