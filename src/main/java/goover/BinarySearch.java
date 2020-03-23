package goover;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-16 21:49
 * @ Description: 这个是二分查找法
 **/
public class BinarySearch {
    // 二分查找法
    public int binarySearch(int[] ints,int left,int right,int i){
        if (ints.length<=1) return -1; //
        if (left>right) return -1; // 递归调用的结束语句
        int mid = (left + right) / 2;
        if (i<ints[mid]){
            right = mid - 1;
            return binarySearch(ints, left, right, i);
        }else if (i>ints[mid]){
            left = mid + 1;
            return binarySearch(ints, left, right, i);
        }else{
            return mid;
        }

    }
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,33,55,78};
        int i = 3;
        BinarySearch binarySearch = new BinarySearch();
        int i1 = binarySearch.binarySearch(ints, 0, ints.length - 1, i);
        System.out.println(i1);
    }
}
