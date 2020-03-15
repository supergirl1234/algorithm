package com;

/*
* 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
* 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
* （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
*
* */


/*
* 思路：先计算前i - 1个元素的乘积，后计算N - i个元素的乘积，然后再将这两个乘积相乘
*
* 用矩阵的上三角、下三角关系计算
* */
import java.util.ArrayList;
public class Solution2 {
    public int[] multiply(int[] A) {


        int[] B=new int[A.length];
        if(A.length==0){
            return  null;
        }
        B[0]=1;
        /*先计算前i - 1个元素的乘积*/

        for (int i=1;i<B.length;i++){
            B[i]=B[i-1]*A[i-1];
        }
        int temp=1;
        for(int i=B.length-2;i>=0;i--){
            temp=temp*A[i+1];/*后计算N - i个元素的乘积*/
            B[i]=B[i]*temp;/*然后再将这两个乘积相乘*/

        }
        return  B;
    }

    public static void main(String[] args) {

    }
}