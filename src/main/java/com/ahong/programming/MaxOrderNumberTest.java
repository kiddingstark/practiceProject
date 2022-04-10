package com.ahong.programming;

/**
 * @Description 输出数组中最大有序序列的长度
 * @Author Ricky
 * @Date 2022/2/21 13:58
 */
public class MaxOrderNumberTest {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 6, 5, 7, 9, 11, 13, 10};
        int max = compute(a);
        System.out.print("最大有序序列为：" + max);
    }

    public static int compute(int[] a) {
        int max = 1;
        int length = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] <= a[i + 1]) {
                length++;
                max = max <= length ? length : max;
            } else {
                length = 1;
            }
        }
        return max;
    }
}
