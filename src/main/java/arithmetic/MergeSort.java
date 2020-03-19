package arithmetic;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-19 15:19
 * @ Description: 这个是一个归并排序，思想是 先分 在和 的思想
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        System.out.println("排序前的顺序：" + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后的顺序：" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 要分成 左递归和右递归
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            // 递归分解完了之后要进行一个 合并的操作
            merge(arr, left, mid, right, temp);
        }
    }

    // 这个方法要进行最后的合并操作
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 初始化 i ,左边有序序列的初始索引
        int j = mid + 1;// 初始化 j, 右边有序序列的初始索引
        int t = 0; // 临时数组的初始索引
        // 1. 先把左右两边的有序序列按照填充规则填充到temp 数组当中去。
        // 直到有一遍填充完了 在继续下面的事情
        while (i <= mid && j <= right) { // 直到有一边到了头 就结束
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        // 判断一下到底是那边没有填充完。
        while (i <= mid) {
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // 进行从 temp 拷贝到 arr 数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft += 1;
            t += 1;
        }
    }
}
