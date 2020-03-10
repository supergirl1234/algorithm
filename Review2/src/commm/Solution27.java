package commm;


import java.util.ArrayList;

/*
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。(输出结果排序)
 *
 * */
public class Solution27 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length){

            return  result;
        }
        for (int i = 0; i < k; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {

                if (input[j] < input[min]) {
                    min = j;

                }
            }
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;

            result.add(input[i]);
        }


        return result;
    }

    public static void main(String[] args) {

        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> result = GetLeastNumbers_Solution(array, k);
        System.out.println(result);

    }
}
