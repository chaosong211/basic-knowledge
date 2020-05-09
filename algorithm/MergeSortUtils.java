package com.example.demo.utils;

import org.hibernate.validator.constraints.br.CPF;

import java.util.Arrays;

public class MergeSortUtils {


    public static void main(String[] args) {

       // int a[] = {2, 1, 7, 9, 5, 8};
        int num = 50;
        int[] a = ArrayGenerator.generateIntArray(num);
        System.out.println(Arrays.toString(a));
        mergeSort(a, num);
        System.out.println(Arrays.toString(a));
        System.out.println(SortUtils.validate(a));
    }

    public static void mergeSort(int[] a, int n) {

        mergeSortInternally(a, 0, n - 1);

    }

    //recursively separate one array into two until one element in one array
    private static void mergeSortInternally(int[] a, int low, int high) {

        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortInternally(a, low, mid);
        mergeSortInternally(a, mid + 1, high);
        System.out.println("low:" + low + ", mid:" + mid + ", high:" + high);
        merge(a, low, mid, high);
    }


    /**
     * @date 2020-05-04
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] a, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = low;
        int[] copy = a.clone();
        while (k <= high) {
            if (i > mid) {
                a[k++] = copy[j++];
            } else if (j > high) {
                a[k++] = copy[i++];
            } else if (copy[i] > copy[j]) {
                a[k++] = copy[j++];
            } else {
                a[k++] = copy[i++];
            }
        }
        System.out.println(Arrays.toString(a));
    }

 /*   private static void merge(int[] a, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        int start = j;
        int end = high;
        if (j > high) {
            start = i;
            end = mid;
        }
        while (start <= end) {
            temp[k++] = a[start++];
        }
        for (i = 0; i <= high - low; i++) {
            a[low+i] = temp[i];
        }
        System.out.println(Arrays.toString(a));
    }*/



    /**
     * @date 2020-05-04
     * @param a
     * @param low
     * @param mid
     * @param high
     * @desc 1.compare and insert 2.insert the left-over 3.copy back to the original array
     */
    public static void merge2(int[] a, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        // loop two intervals and compare with each other, then put them into a new array one by one
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // deal with the left-over data
        // default: left-over data lies in the left interval
        int start = i;
        int end = mid;
        if (j <= high) {
            //left-over data lies in the right interval
            start = j;
            end = high;
        }
        while (start <= end) {
            temp[k++] = a[start++];
        }
        // put temp data back to the original array
        for (i = 0; i < temp.length; i++) {
            a[low+i] = temp[i];
        }
    }




}
