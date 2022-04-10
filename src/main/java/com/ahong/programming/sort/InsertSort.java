package com.ahong.programming.sort;

/**
 * @Description 假设左边已有序，在右边的无序区找第一个插入到最左边（插入的顺序在有序区中不固定）
 * @Author Ricky
 * @Date 2022/2/19 18:13
 */
public class InsertSort {

    public static void main(String[] args) {
        //int a[] = {5, 2, 4, 6, 1, 3};
        int a[] = {7, 6, 9, 3, 1, 5, 2, 4};
        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(",");
            }
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
