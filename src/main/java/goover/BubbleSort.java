package goover;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-16 21:35
 * @ Description: 冒泡排序
 **/
public class BubbleSort {
    public void bubbleSort(int[] arrs) {
        if (arrs.length <= 1)
            return;
        for (int i = 0; i < arrs.length; i++) {
            boolean flag = false; // 优化一下 减少一下代码的次数
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 33, 22, 7};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("排序之前的顺序： " + Arrays.toString(arrs));
        bubbleSort.bubbleSort(arrs);
        System.out.println("排序之后的顺序： " + Arrays.toString(arrs));
    }
}
