package com.example.demo.utils;

public class ArrayGenerator {


    public static int[] generateIntArray(int n) {

        if (n < 1) {
            n = 6;
        }
        int[] arr = new int[n];

        for (int i=0; i < n; i++) {

            arr[i] = (int)(Math.round(Math.random()*100));
        }
        return arr;
    }

    public static int[] generateIntArrayInOrder(int n) {

        int[] a = generateIntArray(n);
        SortUtils.insertionSort(a, n);
        return a;
    }

    public static void main(String[] args) {

        int num = 10;
        int[] array = generateIntArray(num);
        for (int i = 0; i < num; i++) {
            System.out.println(array[i]);
        }

    }

}
