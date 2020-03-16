package com;

/*
*
* 给定大小为n的整数集合A，代表n根木棍的长度。从A中任选4根木棍组成一个四边形，求其面积最大为多少。数据保证有解。
* 程序返回结果与正确答案的误差应小于0.00001
* 例子：
* 输入
[1,2,3,4,5]
输出
10.95445
* */

/*
* 计算：Smax= (p−a)(p−b)(p−c)(p−d)，2p=a+b+c+d
​

* */
public class Solution5 {
    /**
     *
     * @param a int整型一维数组
     * @return double浮点型
     */
    public static double solve (int[] a) {
       double max=0;
       for(int i=0;i<a.length;i++){

           for(int j=i+1;j<a.length;j++){
               for(int m=j+1;m<a.length;m++){
                   for(int n=m+1;n<a.length;n++){

                       double num=Cal(a[i],a[j],a[m],a[n]);
                       if(num>max){
                           max=num;
                       }
                   }
               }
           }
       }

       return  max;
    }

    /*计算一个四边形的面积*/
     public static  double Cal(int a,int b,int c,int d){

         //判断是否能构成四边形
         if(a>=b+c+d){
             return 0;
         }
         if(b>=a+c+d){
             return 0;
         }
         if(c>=a+b+d){
             return 0;
         }
         if(d>=a+b+c){
             return 0;
         }

         double num=(a+b+c+d)/2.0;//必须是2.0，否则牛客上编译通不过
         double result=(num-a)*(num-b)*(num-c)*(num-d);
         return  Math.sqrt(result);

     }
    public static void main(String[] args) {

         int[] num=new int[]{1,2,3,4,5};
         double result=solve(num);
        System.out.println(result);

    }
}
