package com;

/*
* 牛牛有两个长度为n的数组a,b，牛牛希望统计有多少数对(l, r)满足：
1、0<=l<=r<=n-1
2、a中下标从l到r的数值的和=b[l]+b[r];
​	​

示例
输入：[1,2,3,4],[2,1,4,5]
输出：4
说明：满足条件的数对有(0, 1), (0, 2), (1, 1), (1, 2)(0,1),(0,2),(1,1),(1,2)
* */

/*
* 思路：
* 将a中的每个元素之前的和都先计算出来，
* 并且放入一个新数组中。每次遍历比较时只需要计算新数组中 l 和 r 两个位置的差值 ，即为a[l]到a[r]的元素的
*
* */
public class Solution6 {

    /**
     * 计算有多少对符合条件的数对
     * @param a int整型一维数组 数组a
     * @param b int整型一维数组 数组b
     * @return int整型
     */
    public int countLR (int[] a, int[] b) {

             int result=0;
            int[] sumA=new int[a.length];
            sumA[0]=a[0];
            for(int i=1;i<a.length;i++){
                sumA[i]=sumA[i-1]+a[i];
            }

            for(int i=0;i<b.length;i++){
                for(int j=i;j<b.length;j++){

                    if(i==j){
                        if(a[i]==2*b[j]){
                            result++;
                        }
                    }else {
                        if(sumA[j]-sumA[i]+a[i]==b[i]+b[j]){
                            result++;
                        }
                    }
                }
            }

            return  result;
        }

    public static void main(String[] args) {

    }
}
