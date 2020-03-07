package com;


import java.util.ArrayList;

/*
* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
* 如果有多对数字的和等于S，输出两个数的乘积最小的。
*
* 输出描述：
* 对应每个测试案例，输出两个数，小的先输出。
* */

/*
* 思路：双指针，且最外层的乘积最小
*
* */
public class Solution5 {

    public  static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list=new ArrayList<>();
        int left=0;
        int right=array.length-1;

        while(left<right){

            if(sum>array[left]+array[right]){
                left++;
            }else if(sum<array[left]+array[right]){

                right--;
            }else{
                list.add(array[left]);
                list.add(array[right]);
                break;

            }

        }

        return  list;
    }
    public static void main(String[] args) {

        int[] array=new int[]{1,2,4,6,8,10};
        int sum=12;
        ArrayList<Integer> list=FindNumbersWithSum(array,sum);
        System.out.println(list);
    }
}
