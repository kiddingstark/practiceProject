package com.ahong.programming.sort;

/**
 * @Description 选择排序，在无序区中选择一个最小的插入到有序区后面，与插入排序不同（插入排序是直接选择无序区第一个插入到有序区特定位置）
 * @Author Ricky
 * @Date 2022/2/22 0:55
 */
public class SelectSort {

    public static void main(String[] args) {
        int a[] = {7, 6, 9, 3, 1, 5, 2, 4};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(",");
            }
        }
    }

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;//先假设最小数为第一个
            for (int j = i + 1; j < a.length; j++) {
                //将最小数与后面的数据比较，得出一个最小数并保存该下标
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            //一轮比较下来看minIndex的位置变化，将minIndex与i进行交换
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }
}
