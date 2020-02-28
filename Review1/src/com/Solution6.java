package com;


/*
* Fibonacci数列是这样定义的：
F[0] = 0
 F[1] = 1
 for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。
给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，
现在给你一个数N求最少需要多少步可以变为Fibonacci数。
* */
public class Solution6 {



    /*
    * 思路就是：去求Fibonacci数；直到求到的Fibonacci数  > 你输入的数
    * F[i-1]   F[i-2]  F[i]
     *
    * F[i] = F[i-1] + F[i-2]
    * F[i-1]=F[i-2]
    * F[i-2]=F[i]
    * 依次循环
    * */
    public static  int test(int N){

        int a=0;
        int b=1;
        int c=1;
        while (c<N){

            a= b+c;//求出来的新的Fibonacci数

            b=c;
            c=a;
        }

        int left=N-b;
        int right=c-N;
        return  left<right?left:right;
    }
    public static void main(String[] args) {

        int N=7;
        int num=test(N);
        System.out.println(num);
    }
}
