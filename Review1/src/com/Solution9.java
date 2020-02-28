package com;


import java.util.ArrayList;

/*
* 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
* 请编写一个函数，使用递归的方法生成N位的格雷码。
给定一个整数n，请返回n位的格雷码，顺序为从0开始。
* */
public class Solution9 {


    public static ArrayList<String> test(int n){
        ArrayList<String>  list=new ArrayList<>();
        if(n==1){

         list.add("0");
         list.add("1");
         return  list;
        }
        ArrayList<String> preList=test(n-1);
        for(int i=0;i<preList.size();i++){
            String str=preList.get(i);
            list.add('0'+str);
            list.add('1'+str);
        }
        return  list;
    }
    public static void main(String[] args) {

        int n=6;
        ArrayList<String> list=test(n);
        System.out.println(list);

    }
}
