package commm;

import java.util.Arrays;

/*
 * 统计一个数字在排序数组中出现的次数。
 * */
public class Solution1 {

        public static int GetNumberOfK(int[] array, int k) {

          /*二分查找*/
            int result=0;
            if(array.length==0||k>array.length||k > array[array.length-1]){
                return  result;
            }

            int left=0;
            int right=array.length-1;
            int middle=0;
            while (left<right){
                int mid=(left+right)/2;
                if(k<array[mid]){
                    right=mid-1;
                }else if(k>array[mid]){
                    left=mid+1;
                }else {
                    middle=mid;
                    break;
                }
            }
            for (int i = middle; i >= left; i--) {
                if (array[i] == k) {

                    result++;
                }else{
                    break;
                }
            }
            for (int i = middle+1; i <= right; i++) {
                if (array[i] == k) {

                    result++;
                }else {
                    break;
                }
            }
            return  result;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,3,3,3,4,5};
        int k=3;
        System.out.println(GetNumberOfK(array,k));

    }
}
