package com.ahong.programming.sort;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/1/16 23:17
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {65, 58, 95, 10, 57, 62, 13};

        quickSort(a, 0, a.length - 1);

    }

    public static void quickSort(int[] a, int first, int end) {
        int pivot;
        if (first < end) {
            pivot = partition(a, first, end);
            quickSort(a, 0, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    public static int partition(int[] a, int first, int end) {
        int i = first;
        int j = end;
        while (i < j) {
            while (i < j && a[i] <= a[j]) {//从右往左扫描
                j--;
            }
            if (i < j) {
                //交换并i++
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
            while (i < j && a[i] <= a[j]) {//从左往右扫描
                i++;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
            }
        }
        return i;
    }


}
