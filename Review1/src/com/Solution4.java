package com;

import java.util.ArrayList;

/*
 * 找出n个数里最小的k个
 * 输出n个整数里最小的k个数，升序输出
 * */
public class Solution4 {

    public static ArrayList<Integer> test(int[] array,int k){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            int min=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]<array[min]){

                    min=j;
                }

            }
            int temp=array[array.length-1-i];
            array[array.length-1-i]=array[min];
            array[min]=temp;
        }


        for(int i=array.length-1;i>=array.length-k;i--){
            list.add(array[i]);

        }
        return  list;
    }
    public static void main(String[] args) {

        int[] array=new int[]{1,2,5,3,-1,5,8,9,4};
        ArrayList<Integer> list=test(array,3);
        System.out.println(list);
    }
}
