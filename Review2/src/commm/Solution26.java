package commm;

import java.util.ArrayList;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * */
public class Solution26 {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        /*设置边界值*/
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {

            /*往右走*/
            for (int j=left; j <=right; j++) {
                    list.add(matrix[up][j]);
            }
            up++;
            /*
            * 判断是否出界
            * */
            if(up>down){
                break;

            }
            /*往下走*/
            for (int i=up; i <=down; i++) {
                    list.add(matrix[i][right]);
            }
            right--;
            if(left>right){

                break;
            }
            /*往左走*/
            for (int j=right; j >= left; j--) {
                    list.add(matrix[down][j]);
            }
            down--;
            if(up>down){
                break;

            }
            /*往上走*/
            for (int i=down; i >= up; i--) {
                    list.add(matrix[i][left]);

            }
            left++;
            if(left>right){

                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int[][] array=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list=printMatrix(array);
        System.out.println(list);
    }
}
