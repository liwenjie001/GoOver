package arithmetic;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-16 22:32
 * @ Description: 快速排序
 * 思想： 一组数据要进行排序
 * 15，7，10，8，16
 * 取数组最左边的数字为左点l(15)，取数组右边的数字为右点R(16) 取数组的中间值为基准点（10）
 * 左点向右走直到大于中间值，右点向左走直到小于中间值。然后交换左右点的值。
 * 当左边走完了或者右边走完了的时候，可以使用递归调用就可以了。
 **/
public class QuickSort {

    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] ints = {15, 7, 10, 8, 16};
        System.out.println("快速排序之前的顺序： " + Arrays.toString(ints));
        quickSort(ints, 0, ints.length - 1);
        System.out.println("快速排序之后的顺序： " + Arrays.toString(ints));
    }
}
