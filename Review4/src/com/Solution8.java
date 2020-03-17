package com;


import java.util.Arrays;

/*
* 众所周知，牛妹是一个offer收割姬，这次面试她遇到了这样的一个问题。
给了一个序列，让找出最长的“凸子序列”
何为“凸子序列”：数列中有一个xi,使得所有x0<x1<x2….xi-1<xi且xi>xi+1>xi+1>….>xn
eg：12345431,是山峰序列，12345234不是山峰序列
注：单调递增或单调递减序列也算山峰序列；单独一个数是长度为1的山峰序列
*
*
* 输入:[1,2,3,6,1]
输出:5
* */

/*
* 这是一个动态规划问题
*
* */
public class Solution8 {
    /**
     * 返回最大山峰序列长度
     * @param numberList int整型一维数组 给定的序列
     * @return int整型
     */
    public static int mountainSequence (int[] numberList) {

        if(numberList.length==0){
            return  0;
        }
        if(numberList.length==1){
            return  1;
        }

        int[] ltLeftArray=new int[numberList.length];//存储numberList中前面的数比当前数小的个数+1
        int[] ltRightArray=new int[numberList.length];//储numberList中后面的数比当前数小的个数+1

        /*初始化这两个数组*/
       /* for(int i=0;i<numberList.length;i++){
            *//*因为单独一个数是长度为1的山峰序列，所以每位初始化为1*//*
            ltLeftArray[i]=1;
            ltRightArray[i]=1;
        }*/
        Arrays.fill(ltLeftArray, 1);
        Arrays.fill(ltRightArray, 1);

        /*先判断numberList中前面的数比当前数小的个数*/
        for(int i=1;i<numberList.length;i++){

            for(int j=i-1;j>=0;j--){
                if(numberList[j]<numberList[i]){
                    ltLeftArray[i]=Math.max(ltLeftArray[i],ltLeftArray[j]+1);
                }
            }
        }
        /*再判断numberList中后面的数比当前数小的个数*/
        for(int i=numberList.length-2;i>=0;i--){

            for(int j=i+1;j<=numberList.length;j++){
                if(numberList[j]<numberList[i]){
                    ltRightArray[i]=Math.max(ltRightArray[i],ltRightArray[j]+1);
                }
            }
        }
        int result=0;
        for(int i=0;i<numberList.length;i++){
            if(ltLeftArray[i]+ltRightArray[i]-1>result){
               result= ltLeftArray[i]+ltRightArray[i]-1;
            }
        }
        return  result;
    }
    public static void main(String[] args) {

        int[] array=new int[]{1,4,3,6,1};
        int result=mountainSequence(array);
        System.out.println(result);
    }
}
