package arithmetic;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-11 09:18
 * @ Description: 二分查找 时间复杂度O(log2n),空间复杂度 O(1)
 * 思想： 要有递归推出条件
 **/
public class BinarySearch {
    public int binarySearch(int[] ints,int i,int left,int right){
        if (ints.length<=1) return -1;
        int mid = (left + right) / 2;
        if (left>right){ // 递归推出条件，找不到，返回-1
            return -1;
        }
        if (i< ints[mid]){ // 向左递归
            return binarySearch(ints, i, left, mid-1);
        }else if(i>ints[mid]){ // 向右递归
            return binarySearch(ints, i, mid+1, right);
        } else {
            return mid;
        }


    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,7,9};
        int i = 2;

        BinarySearch binarySearch = new BinarySearch();
        int i1 = binarySearch.binarySearch(ints, i,0,ints.length-1);
        System.out.println(i1);

    }
}
