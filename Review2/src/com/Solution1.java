package com;


/*
* 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*
* */

/*
* 思路：从二维数组的左下角开始比较，如果target>该位置的数,则往右走；如果target<该位置的数，则往上面走
*
* */
public class Solution1 {

    public  static boolean Find(int target, int [][] array) {


        for(int i=array.length-1,j=0;i>=0&&j<array[0].length;){


                if(target<array[i][j]){
                    i--;

                }else if(target>array[i][j]){

                    j++;

                }else{
                    return  true;
                }


        }
        return  false;
    }
    public static void main(String[] args) {

        int[][] array=new int[][]{{1,2,3,4,5},{2,7,8,9,10},{11,12,13,14,15}};

        boolean result=Find(5,array);
        System.out.println(result);
    }
}
