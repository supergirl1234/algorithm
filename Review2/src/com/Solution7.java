package com;


/*
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0
* */
public class Solution7 {

    public  static double Power(double base, int exponent) {

        double  result=1;
        if (base==0) {
            return 0;
        }
        if (exponent==0) {
            return  result;
        }

      /*  int num=0;
        if(exponent>0){

            num=exponent;
        }else{

            num=-exponent;
        }*/

        int num=exponent>0?exponent:-exponent;


        for(int i=0;i<num;i++){

            result *=base;
        }
         return   exponent>0?result:1/result;

    }

    public static void main(String[] args) {

        System.out.println(Power(2,3));
        System.out.println(Power(2,-3));

    }
}
