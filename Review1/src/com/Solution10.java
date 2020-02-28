package com;


/*
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。
 * 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 * 现给定数字，请编写程序输出能够组成的最小的数。
 * 该题目的输入数据是由 10 个数字组成，表示 0 -9 出现的次数，
 * */
public class Solution10 {


    public static int test(int[] array) {
        StringBuffer str = new StringBuffer();


        /*先找出第一个除了0以外最小的数*/
            for (int i = 1; i < array.length; i++) {
                int num=array[i];
                if(num!=0){
                    array[i]--;
                    str.append(i);
                    /*如果存在0.再将0拼接在后面*/
                    for(int k=0;k<array[0];k++){
                        str.append(0);
                    }
                }
                break;
            }

            /*继续按顺序拼接*/
            for (int i = 1; i < array.length; i++) {
                int num=array[i];
                for(int j=0;j<num;j++){
                    str.append(i);
                }

            }

        return Integer.parseInt(str.toString());
    }

    public static void main(String[] args) {


        int[] array = new int[]{2, 2, 0, 0, 0, 3, 0, 0, 1, 0};

        int num = test(array);
        System.out.println(num);
    }
}
