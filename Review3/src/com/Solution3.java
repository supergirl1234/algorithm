package com;


import java.util.ArrayList;

/*
* 输入一个递增排序的数组nums和一个数字target (数组nums中的数字和target的数值均为正整数)，
* 在数组中查找两个数，使得它们的乘积正好是target。
* 如果有多对数字的乘积等于target，输出全部组合
*
* */
public class Solution3 {

    public  static ArrayList<ArrayList<Integer>>  test(int[] num,int target){

        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
       ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<num.length;i++){
            list.add(num[i]);
            testInner(num,i+1,target,list);
            if(list.size()==2){
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            }else{
                list.remove(list.size()-1);
            }
        }
        if(lists.size()<=0){
            list.add(-1);
            list.add(-1);
            lists.add(list);
        }


        return  lists;
    }

    private static void testInner(int[] num, int index, int target, ArrayList<Integer> list) {
        for(int i=index;i<num.length;i++){
            if(target==list.get(0)*num[i]){
                list.add(num[i]);
                break;
            }
        }

    }

    public static void main(String[] args) {

        //int[] array=new int[]{1,2,4,5,7,8,11,12,15};
        //int target=60;
        int[] array=new int[]{5,7,9,10,13};

        int target=64;
        ArrayList<ArrayList<Integer>> result=test(array,target);
        System.out.println(result);
    }
}
