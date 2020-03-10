package arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-10 11:32
 * @ Description:冒泡排序 要求时间复杂度在O(n^2) 空间复杂度在O(1)
 **/
public class BubbleSort {
    public int[] bubbleSort(int[] ints){
        if (ints.length<=1){
            return ints;
        }
        for (int i = 0; i < ints.length; i++) {
            boolean flag = false;
            for (int j = 0; j < ints.length-i-1; j++) {
                if (ints[j]>ints[j+1]){
                    int temp = 0;
                    temp = ints[j+1];
                    ints[j+1] = ints[j];
                    ints[j] = temp;
                }

            }
            System.out.println(Arrays.toString(ints));
            if (!flag) break;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = {1,3,6,2,4};
        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("排序前的顺序："+ Arrays.toString(ints));

        int[] ints1 = bubbleSort.bubbleSort(ints);
        System.out.println("排序后的顺序："+Arrays.toString(ints1));

    }
}
