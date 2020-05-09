package com.example.demo.utils;

import java.util.Arrays;

public class QuickSortUtils {


    public static void main(String[] args) {

        int[] a = ArrayGenerator.generateIntArray(6);
        System.out.println(Arrays.toString(a));
        QuickSortUtils quickSortUtils = new QuickSortUtils();
        quickSortUtils.quickSort(a);
        System.out.println(Arrays.toString(a));
    }


    public void quickSort(int[] a) {

        if (a == null || a.length == 0) {
            return;
        }
        quickSortInternally(a, 0, a.length - 1);
    }

    private void quickSortInternally(int[] a, int low, int high) {

        if ( low >= high) {
            return;
        }
        int pivot = partition(a, low, high);
        quickSortInternally(a, low, pivot -1);
        quickSortInternally(a, pivot + 1, high);
    }

    private int partition(int[] a, int low, int high) {

        int pivot = a[high];
        int i = low;
        int j = low; 
        while (j < high) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                    j++;
                    continue;
                } else {
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            } else {
                j++;
            }
        }
        a[high] = a[i];
        a[i] = pivot;
        return i;
    }


}
