package com;

/*  求两个数的最小公倍数*/

/*
*
* 思路：两个数的乘积等于这两个数的最大公约数与最小公倍数的积
 * 求最大公约数：
 * 1. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
 * 2. 互换：置 a←b，b←r，并返回第一步
* */
public class Solution2 {

    /*两个数的乘积等于这两个数的最大公约数与最小公倍数的积*/
    /*求两个数的最小公倍数*/
    public static  int test1(int a,int b){


         return (a*b)/test2(a,b);


    }
    /*求两个数的最大公约数*/

    /*
    * 求最大公约数思路：
     * 1. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
     * 2. 互换：置 a←b，b←r，并返回第一步*/
    public static  int test2(int a,int b){


        if(b==0){

            return  a;
        }
        return test2(b,a%b);



    }
    public static void main(String[] args) {
        int a=3;
        int b=6;
        int num1=test1(a,b);
        System.out.println(a+"与"+b+"的最小公倍数为:"+num1);
        int num2=test2(a,b);
        System.out.println(a+"与"+b+"的最大公约数为:"+num2);



    }
}
