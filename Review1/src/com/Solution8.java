package com;

import java.util.ArrayList;

/*
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
 * 请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 * */
public class Solution8 {


    public static void test(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        String str = String.valueOf(N);
        for (int i = 0; i < str.length(); i++) {
            list.add(0);
        }
        for(int i = 0; i < str.length(); i++){
            list.set(str.charAt(i)-'0',list.get(str.charAt(i)-'0')+1);
        }
        for(int i = 0; i < str.length(); i++){
            if(list.get(i)!=0){
                System.out.println(i+"的个数为:"+list.get(i));
            }
        }
    }
    public static void main(String[] args) {

        int N = 100311;
         test(N);

    }
}
