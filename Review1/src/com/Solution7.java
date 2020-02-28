package com;
/*
* 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。

给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。

* */
public class Solution7 {


    public static int test(int x,int y){

        if (x==1||y==1){
            return  1;
        }
        return  test(x,y-1)+test(x-1,y);
    }
    public static void main(String[] args) {

        int x=5;
        int y=6;
        int num=test(x,y);
        System.out.println(num);

    }
}
