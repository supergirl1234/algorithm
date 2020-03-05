package com;

import java.util.ArrayList;

public class Solution31 {


    public static ArrayList<ArrayList<Integer>> test1(int[] num,int target){

        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        for(int i=0;i<num.length;i++){

            for(int j=i+1;j<num.length;j++){
                if(num[i]*num[j]==target){

                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[j]);
                    lists.add(list);
                    break;
                }

            }
        }
        if(lists.size()<=0){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(-1);
            list.add(-1);
            lists.add(list);
        }
        return  lists;
    }
    public static void main(String[] args) {

    }
}
