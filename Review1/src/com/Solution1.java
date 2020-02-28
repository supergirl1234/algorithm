package com;


/*输入n个整数，输出出现次数大于等于数组长度一半的数。*/

/*
* 思路：
* 因为要找的数字在数组中出现的次数比其他数字加起来的次数还要多，因此，在遍历数组时，只要维护两个变量，
* 一个是当前的数字，一个是当前的次数，如果遍历到的数字和当前的相同，则次数加1，
* 如果不同则次数减1，如果次数已经减为0，则重新设置当前的数组并使次数为1。
* 只要这样做，最终保留的数字一定是出现次数超过一半的那个数字。
*
* */
public class Solution1 {


    public static int test(int[] array){



        int num=array[0];
        int count=1;
        for(int i=1;i<array.length;i++){
            if(array[i]==num){

                count++;
            }else if(count==0){

                num=array[i];
                count=1;
            }else {

                count--;
            }

        }

        return  num;


    }
    public static void main(String[] args) {

        int[] array=new int[]{1,1,2,2,1};
        int num=test(array);
        System.out.println(num);
    }
}
