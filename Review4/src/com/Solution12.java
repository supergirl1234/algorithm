package com;

/*
*
*
* 众所周知，牛妹需要很多衣服，有直播的时候穿的、有舞剑的时候穿的、有跳舞的时候穿的、有弹琴的时候穿的，等等
* 这些衣服都是由固定大小的矩形布料裁剪而成，心灵手巧的牛妹也知道每件衣服所需要的具体矩形布料的长和宽
* 然而，她只有一块大的布料可供她裁剪。裁剪的时候可以随便剪
* 那么问题来了，美腻的牛妹能最多可以做出多少件衣服呢？
*
*
* 输入:3,5,[[3 ,1],[4,1],[2,2],[2,2]]
* 输出:5
* */
public class Solution12 {

    /**
     *
     * @param L int整型 给定布料的长
     * @param W int整型 给定布料的宽
     * @param clothSize int整型二维数组 依次列举每件衣服所需的长和宽
     * @return int整型
     */
    public static int clothNumber (int L, int W, int[][] clothSize) {

        int[][] dp=new int[L+1][W+1];//dp[i][j]代表的是长度为i,宽为j的布料能做出衣服件数的最大值
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=L;i++) {
            for (int j = 1; j <= W; j++) {
              for(int k=0;k<clothSize.length;k++){

                  int Lcloth=clothSize[k][0];//衣服的长度
                  int Wcloth=clothSize[k][1];//衣服的宽度

                  if(i>=Lcloth&&j>=Wcloth){

                      dp[i][j]=Math.max(dp[i][j],dp[i-Lcloth][j]+dp[Lcloth][j-Wcloth]+1);
                      dp[i][j]=Math.max(dp[i][j],dp[i][j-Wcloth]+dp[i-Lcloth][Wcloth]+1);
                  }
                  if(i>=Wcloth&&j>=Lcloth){
                      dp[i][j]=Math.max(dp[i][j],dp[i-Wcloth][j]+dp[Wcloth][j-Lcloth]+1);
                      dp[i][j]=Math.max(dp[i][j],dp[i][j-Lcloth]+dp[i-Wcloth][Lcloth]+1);
                  }
              }

            }
        }

        return dp[L][W];
    }

    public static void main(String[] args) {

        int L=3;
        int W=5;
        int[][] cloth=new int[][]{
                {3,1},
                {4,1},
                {2,2},
                {2,2}
        };

        int result=clothNumber(L,W,cloth);
        System.out.println(result);
    }
}
