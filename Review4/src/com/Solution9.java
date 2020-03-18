package com;

/*
* 众所周知，牛妹非常喜欢吃蛋糕。
第一天牛妹吃掉蛋糕总数三分之一多一个，第二天又将剩下的蛋糕吃掉三分之一多一个，以后每天吃掉前一天剩下的三分之一多一个，到第n天准备吃的时候只剩下一个蛋糕。
牛妹想知道第一天开始吃的时候蛋糕一共有多少呢？

示例:
输入：2
输出:3
*
* */
/*
* 第n天的蛋糕数为：F（n）；
* 第n+1天的蛋糕数为：F（n+1）=F（n）-（F（n）/3+1）；
* 所以：F（n）=（F（n+1）+1）*3/2；
*
* */
public class Solution9 {
    /**
     *
     * @param n int整型 只剩下一只蛋糕的时候是在第n天发生的．
     * @return int整型
     */
    static int num=1;
    public static int cakeNumber (int n) {

        if(n==1){
            return num ;
        }
        num=(num+1)*3/2;

        return cakeNumber(n-1) ;
    }

    public static int cakeNumber2 (int n) {
        int number=1;
        if(n==1){
            return number ;
        }

      for(int i=n;i>1;i--){
            number=(number+1)*3/2;
      }
        return number ;
    }
    public static void main(String[] args) {

        int n=5;
        int result1=cakeNumber(n);
        System.out.println(result1);
        int result2=cakeNumber2(n);
        System.out.println(result2);
    }
}
