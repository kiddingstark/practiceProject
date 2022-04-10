package com.ahong.programming.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 冒泡排序：最大的冒泡到最右边,两两相邻做比较
 * @Author Ricky
 * @Date 2021/9/22 2:38
 */
public class BubblingSort {

    public static void main(String[] args) {
//        int a[] = {1, 7, 9, 11, 35, 56, 78, 12, 98, 45, 76, 2, 41};
//        bubbleSort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + ",");
//        }
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.forEach(System.out::println);
    }

    public static void bubbleSort(int[] a){
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = i; j < a.length - 1 - i; j++) {
//                if (a[j] > a[j + 1]) {
//                    //调换
//                    int flag = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = flag;
//                }
//            }
//        }

        for (int i = a.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    //调换
                    int flag = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = flag;
                }
            }
        }
    }
}
